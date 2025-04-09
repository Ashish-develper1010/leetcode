class Solution {
    public boolean isPossible(int[] piles , int mid , int  h) {
        int count = 0;

        for(int pile : piles) {
            count += pile%mid == 0 ? pile/mid : (pile/mid) + 1;
        }
        return count<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = piles[0];
        for(int pile : piles) {
            max = Math.max(max , pile);
        }

        
        while(min <= max) {
            int mid = min + (max-min)/2;

            if(isPossible(piles , mid , h)) {
                max = mid-1;
            }
            else {
                min = mid+1;
            }
        }
        return min;
    }
}