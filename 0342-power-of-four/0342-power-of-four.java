class Solution {
    public boolean isPowerOfFour(int n) {
        double res = Math.log10(n) / Math.log10(4);
        return res == (int) res;
    }
}