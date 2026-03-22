class Solution {

    public void rotate(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        // transpose

        for(int i = 0; i < r; i++) {
            for(int j = i; j < c; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }


        // reverse

        for(int i = 0; i < r; i++) {
            int left = 0;
            int right = c - 1;

            while(left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public boolean compare(int[][] mat, int[][] target) {
        int r = mat.length;
        int c = mat[0].length;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(mat[i][j] != target[i][j]) return false;
            }
        }

        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        
        for(int i = 0; i < 4; i++) {
            if(compare(mat , target)) return true;
            rotate(mat);
        }

        return false;
    }
}