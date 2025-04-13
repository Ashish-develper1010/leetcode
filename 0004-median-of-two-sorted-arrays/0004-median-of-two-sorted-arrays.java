class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n+m];
        int l = arr.length;

        int i = 0, j = 0, k = 0;

        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            }
            else arr[k++] = nums2[j++];
        }
        while(i < n) {
            arr[k++] = nums1[i++];
        }
        while(j < m) {
            arr[k++] = nums2[j++];
        }
        
        int len = l / 2;
        double ans = 0;

        if(l % 2 == 0) {
            int sum = arr[len] + arr[len-1];
            ans = sum / 2.0;
        }
        else ans = arr[len];
        return ans;
    }
}