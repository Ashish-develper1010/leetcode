class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        while(true) {
            if(linearSearch(nums , original)) {
                original *= 2;
            }
            else return original;
        }
    }

    private boolean linearSearch(int[] nums , int orig) {
        for(int num : nums) {
            if(num == orig) return true;
        }
        return false;
    }
}