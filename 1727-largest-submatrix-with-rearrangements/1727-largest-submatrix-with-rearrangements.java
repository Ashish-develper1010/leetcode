class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 1; i < row; i++ ){
            for(int j = 0; j < col; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        for(int[] arr : matrix) {
            Arrays.sort(arr);
            for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Calcualte area 
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int area = matrix[i][j] * (j + 1);
                max = Math.max(max, area);
            }
        }

        return max;
    }
}