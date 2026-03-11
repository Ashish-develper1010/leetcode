class Solution {
    public int bitwiseComplement(int n) {
        int ans = 0, pow = 1;

        if(n == 0) return 1;

        while(n > 0) {
            int digit = 1 - (n % 2);
            ans += digit * pow;
            pow *= 2;
            n /= 2;
        }

        return ans;
    }
}