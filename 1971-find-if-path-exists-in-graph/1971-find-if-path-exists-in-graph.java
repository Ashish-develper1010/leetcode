class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for(int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return bfs(adj, source, destination);
    }

    private boolean bfs(List<List<Integer>> adj, int src, int dest) {

        Queue<Integer> qu = new LinkedList<>();
        boolean[] vis = new boolean[adj.size()];

        qu.offer(src);
        vis[src] = true;

        while(!qu.isEmpty()) {

            int curr = qu.poll();

            if(curr == dest) return true;

            for(int nei : adj.get(curr)) {

                if(!vis[nei]) {
                    vis[nei] = true;
                    qu.offer(nei);
                }
            }
        }

        return false;
    }
}