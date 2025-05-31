class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0 , right = n-1;
        int leftmax = 0 , rightmax = 0;
        int trapped = 0;

        while(left < right) {
            if(height[left] <= height[right]) {
                if(leftmax <= height[left]) {
                    leftmax = height[left];
                }
                else trapped += leftmax - height[left];
                left++;
            }
            else {
                if(rightmax <= height[right]) {
                    rightmax = height[right];
                }
                else {
                    trapped += rightmax - height[right];
                }
                right--;
            }
        }
        return trapped;
    }
}