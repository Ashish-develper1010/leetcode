class Solution {
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    
    private boolean dfs(char[][] grid, boolean[][] visited,
                        int x, int y, int px, int py) {
        
        visited[x][y] = true;
        
        for(int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            
            // boundary check
            if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                continue;
            
            // same character check
            if(grid[nx][ny] != grid[x][y])
                continue;
            
            // skip parent
            if(nx == px && ny == py)
                continue;
            
            // cycle condition
            if(visited[nx][ny])
                return true;
            
            // explore further
            if(dfs(grid, visited, nx, ny, x, y))
                return true;
        }
        return false;
    }
    
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    if(dfs(grid, visited, i, j, -1, -1))
                        return true;
                }
            }
        }
        return false;
    }
}