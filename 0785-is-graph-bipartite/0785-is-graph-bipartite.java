class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        

        for(int i = 0; i < n; i++) {
            if(vis[i] == -1) {
                vis[i] = 0;
                if(!dfs(graph, i, vis)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] vis) {
        // if(i == 0) vis[i] = 0;   
        

        for(int ele : graph[i]) {
            if(vis[ele] == -1) {
                vis[ele] = 1 - vis[i];
                if(!dfs(graph, ele, vis)) return false;
            }
            else if (vis[i] == vis[ele]) return false;
        }
        return true;
    }

    private boolean bfs(int[][] graph, int i, int[] vis) {
        vis[i] = 0;
        Queue<Integer> q = new LinkedList<>();

        q.add(i);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int ele : graph[curr]) {
                if(vis[ele] == -1) {
                    vis[ele] = 1 - vis[curr];
                    q.add(ele);
                }
                else if(vis[ele] == vis[curr]) return false;
            }
        }
        return true;
    }
}