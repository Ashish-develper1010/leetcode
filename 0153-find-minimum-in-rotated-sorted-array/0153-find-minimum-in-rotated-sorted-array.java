class Solution {
    public int findMin(int[] nums) {
        int right = nums.length-1;
        int left = 0;
        if(nums.length == 1) 
            return nums[0];
        if(nums.length == 2) {}
            int min = Math.min(nums[0] , nums[1]); 
            return min;
        }
        while(left < right) {
            int mid = left + (right - left) / 2 ;
            if(nums[left] == nums[mid] || nums[mid] == nums[right]) {
                return nums[left];
            }
            else if(nums[left] < nums[mid] && nums[right] < nums[mid]) {
                left = mid + 1;
            }
            else if(nums[left] < nums[mid] && nums[right] > nums[mid]) {
                right = mid;
            }

        }
        return nums[left];
    }
}