class Solution {
    public int[] shuffle(int[] nums, int n) {
        if(nums.length % 2 != 0 ) return new int[0];

        int[] arr = new int[2*n];

        int i = 0;
        int j = n;
        int k = 0;

        while(i < n && j < 2*n) {
            arr[k] = nums[i];
            k++;
            arr[k] = nums[j];
            i++;
            j++;
            k++;
        }
        return arr;
        
    }
}