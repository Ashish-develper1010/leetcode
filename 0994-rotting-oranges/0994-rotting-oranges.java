class pair {
    int r;
    int c;
    int t;

    public pair(int r, int c, int t) {
        this.r = r;
        this.c = c;
        this.t = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Put all initially rotten oranges into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int maxTime = 0;

        // Step 2: BFS traversal
        while (!q.isEmpty()) {
            pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int t = p.t;

            maxTime = Math.max(maxTime, t);

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Check bounds and if fresh orange
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;  // Make it rotten
                    freshCount--;      // Decrease fresh count
                    q.add(new pair(nr, nc, t + 1));  // Add to queue with incremented time
                }
            }
        }

        // Step 3: If any fresh orange left, return -1
        return (freshCount == 0) ? maxTime : -1;
    }
}
