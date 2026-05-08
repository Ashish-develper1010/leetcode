class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        

        for(int i = 0; i < n; i++) {
            if(vis[i] == -1) {
                if(!bfs(graph, i, vis)) return false;
            }
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