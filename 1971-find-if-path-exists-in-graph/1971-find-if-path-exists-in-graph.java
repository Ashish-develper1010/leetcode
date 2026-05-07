class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return bfs(adj, source, destination);
    }

    private boolean bfs(List<List<Integer>> adj, int src, int dest) {
        int n = adj.size();
        Queue<Integer> qu = new LinkedList<>();
        boolean[] vis = new boolean[n];
        qu.offer(src);
        vis[src] = true;

        while(!qu.isEmpty()) {
            int curr = qu.poll();
            for(int ele : adj.get(curr)) {
                if(!vis[ele]) {
                    qu.offer(ele);
                    vis[ele] = true;
                }
            }
        }

        return vis[dest];
    }
}