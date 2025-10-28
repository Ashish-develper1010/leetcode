class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        if(matrix == null || row == 0 || col == 0) return false;

        int left = 0 , right = row * col - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / col][mid % col];

            if(midValue == target) return true;
            else if(midValue < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}