class Solution {
    public int minOperations(int[][] grid, int x) {
        int row = grid.length;
        int col = grid[0].length;

        int[] newArr = new int[row*col];
        int idx = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                newArr[idx++] = grid[i][j];
                // if(grid[i][j] % x != 0) return -1;
                if((grid[i][j] - grid[0][0]) % x != 0 ) return -1;
            }
        }

        Arrays.sort(newArr);
        int median = newArr[newArr.length / 2];
        int operations = 0;

        for(int i = 0; i < newArr.length; i++) {
            operations += Math.abs(newArr[i] - median) / x;
        }
        return operations;
    }
}