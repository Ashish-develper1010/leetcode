class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for(int num  = left; num <= right; num++) {
            int all = Integer.bitCount(num);
            if(isPrime(all)) count++;

        }
        return count;

    }

    private boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= (num / 2) ; i++) {
            if((num % i) == 0) return false;
        }
        return true;
    }
}