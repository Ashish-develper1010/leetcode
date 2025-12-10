class Solution {
    public long fact(long num) {
        if(num <= 1) return 1;
        return num * fact(num - 1);
    }
    public int countPermutations(int[] complexity) {
        int MOD = 1_000_000_007;
        for(int i = 1; i < complexity.length; i++) {
            if(complexity[0] >= complexity[i]) return 0;
        }

        long ans = fact(complexity.length - 1) % MOD;
        return (int)(ans % MOD);
    }
}