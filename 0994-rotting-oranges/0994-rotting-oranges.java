class Solution {
    class pair {
        int r;
        int c;
        int t;

        public pair(int r , int c, int t) {
            this.t = t;
            this.r = r;
            this.c = c;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int freshOrange = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new pair(i , j , 0));
                }
                else if(grid[i][j] == 1) freshOrange++;
            }
        }

        int maxTime = 0;
        int[][] direction = {{0,1} , {1,0}, {0,-1},{-1,0}};

        while(!q.isEmpty()) {
            pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int t = p.t;

            maxTime = Math.max(maxTime , t);

            for(int[] dir : direction) {
                int row = r + dir[0];
                int col = c + dir[1];

                if(row < n && row >= 0 && col < m && col >= 0 && grid[row][col] == 1) {
                    grid[row][col] = 2;
                    freshOrange--;
                    q.add(new pair(row , col , t+1));
                }
            }
        }
        return freshOrange == 0 ? maxTime : -1;
    }
}