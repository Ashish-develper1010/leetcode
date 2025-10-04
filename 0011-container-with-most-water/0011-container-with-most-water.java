class Solution {
    public int maxArea(int[] height) {
        int n = height.length - 1;
        int left = 0 , right  = n;
        int maxArea = Integer.MIN_VALUE;
        while(n > 0) {
            int area = 0;
            if(height[left] <= height[right]) {
                int min = height[left];
                area = min * n;
                left++;
            }
            else {
                int min = height[right];
                area = min * n;
                right--;
            }
            maxArea = Math.max(maxArea , area);
            n--;
        }
        return maxArea;
    }
}