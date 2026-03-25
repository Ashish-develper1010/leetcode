class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        long totalSum = 0;

        long[] rows = new long[r];
        long[] cols = new long[c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
                totalSum += grid[i][j];
            }
        }

        if(totalSum % 2 != 0) return false;

        long target = totalSum / 2;

        // Horizontal cut
        long sum = 0;
        for(int i = 0; i < r; i++) {
            sum += rows[i];
            if(sum == target) return true;
        }

        // Vertical cut
        sum = 0;
        for(int j = 0; j < c; j++) {
            sum += cols[j];
            if(sum == target) return true;
        }

        return false;
    }
}