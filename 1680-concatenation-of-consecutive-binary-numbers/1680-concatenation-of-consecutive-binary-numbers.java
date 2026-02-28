class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1_000_000_007;
        long result = 0;
        int length = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) { // power of 2 → length increases
                length++;
            }
            result = ((result << length) % mod + i) % mod;
        }

        return (int) result;
    }
}
