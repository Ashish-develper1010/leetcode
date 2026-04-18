class Solution {
    public int mirrorDistance(int n) {
        int rev = reverse(n);

        return Math.abs(n - rev);
    }

    public int reverse(int x) {
        int y = 0;

        while(x > 0) {
            y = (y*10) + (x % 10);
            x /= 10;
        }

        return y;
    }
}