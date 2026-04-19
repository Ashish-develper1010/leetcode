class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int res = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                res = Math.max(res, j - i);
                j++;  // try to expand distance
            } else {
                i++;  // move to smaller nums1[i]
            }
        }

        return res;
    }
}