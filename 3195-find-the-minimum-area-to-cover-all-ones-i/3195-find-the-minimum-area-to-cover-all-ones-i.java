class Solution {
    public int minimumArea(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        int maxRow = -1;
        int minRow = rowLen;
        int maxCol = -1;
        int minCol = colLen;

        for(int i = 0 ; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(grid[i][j] == 1) {
                    minRow = Math.min(minRow , i);
                    maxRow = Math.max(maxRow , i);

                    minCol = Math.min(minCol , j);
                    maxCol = Math.max(maxCol , j);
                }
            }
        }

        int col = maxCol - minCol + 1;
        int row = maxRow - minRow + 1;

        return col * row;
    }
}