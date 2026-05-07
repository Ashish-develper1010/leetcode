class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                bfs(isConnected, vis,i);
                count++;
            }
        }

        return count;
    }

    private void bfs(int[][] adj, boolean[] vis, int i) {
        vis[i] = true;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(i);

        while(!qu.isEmpty()) {
            int curr = qu.poll();
            for(int j = 0; j < adj.length; j++) {
                if(adj[curr][j] == 1 && !vis[j]) {
                    qu.add(j);
                    vis[j] = true;
                }
            }
        } 
    }
}