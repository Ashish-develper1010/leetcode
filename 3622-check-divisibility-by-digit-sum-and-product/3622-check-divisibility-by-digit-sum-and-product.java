class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0;
        long product = 1;
        int duplicate = n;
        while(duplicate != 0 ) {
            int digit = duplicate % 10;
            sum += digit;
            product *= digit;
            duplicate /= 10;
        }

        return n % (product + sum) == 0;
    }
}