class Solution {
    static final int MOD = 1_000_000_007;
    static long[] fact;
    static long[] invFact;

    // Modular exponentiation
    long power(long x, long y) {
        long res = 1;
        x = x % MOD;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % MOD;
            y = y >> 1;
            x = (x * x) % MOD;
        }
        return res;
    }

    // Precompute factorials and inverse factorials
    void precomputeFactorials(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = invFact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[n] = power(fact[n], MOD - 2); // Fermat's inverse
        for (int i = n - 1; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // nCr % MOD
    long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        precomputeFactorials(n); // You need factorials up to n

        // Edge case: not possible
        if (k > n - 1) return 0;

        long choose = nCr(n - 1, k);               // Choose k positions for matching pairs
        long fill = (m * power(m - 1, n - k - 1)) % MOD; // Ways to fill blocks
        long result = (choose * fill) % MOD;

        return (int) result;
    }
}
