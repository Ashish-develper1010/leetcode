class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(isConnected, vis,i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] adj, boolean[] vis, int i) {
        int n = adj.length;
        vis[i] = true;

        for(int j = 0; j < n; j++) {
            if(adj[i][j] == 1 && !vis[j]) {
                dfs(adj, vis, j);
            }
        }
    }
}