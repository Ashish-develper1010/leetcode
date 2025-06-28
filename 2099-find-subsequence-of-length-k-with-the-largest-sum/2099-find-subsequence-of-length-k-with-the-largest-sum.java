class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] arr = new int[nums.length][2];

        for(int i = 0; i < nums.length; i++) {
            arr[i][0] = i;
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr ,(a , b) -> Integer.compare(b[1] , a[1]));

        Arrays.sort(arr , 0 , k ,(a , b) -> Integer.compare(a[0] , b[0]));

        int[] res = new int[k];
        // int i = 0;

        for(int i = 0; i < k; i++) {
            res[i] = arr[i][1];
        }
        return res;
    }
}