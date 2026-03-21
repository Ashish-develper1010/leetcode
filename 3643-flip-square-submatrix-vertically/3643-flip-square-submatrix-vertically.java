class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int topLeft = x;
        int bottomLeft = x+k-1;
        while(topLeft < bottomLeft) {
            for(int topRight = y; topRight < y+k; topRight++) {
                int temp = grid[topLeft][topRight];
                grid[topLeft][topRight] = grid[bottomLeft][topRight];
                grid[bottomLeft][topRight] = temp;
            }
            topLeft++;
            bottomLeft--;
        }
        return grid;
    }
}