class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    bfs(grid, vis, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, boolean[][] vis, int i, int j) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));
        vis[i][j] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {

            Pair p = q.poll();

            int row = p.row;
            int col = p.col;

            for(int k = 0; k < 4; k++) {

                int nrow = row + drow[k];
                int ncol = col + dcol[k];

                if(nrow >= 0 && nrow < grid.length &&
                   ncol >= 0 && ncol < grid[0].length &&
                   grid[nrow][ncol] == '1' &&
                   !vis[nrow][ncol]) {

                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}