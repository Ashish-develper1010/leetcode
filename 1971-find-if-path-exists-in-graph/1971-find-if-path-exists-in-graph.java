class Solution {
    public boolean hasPath(ArrayList<ArrayList<Integer>> graph , int src , int dest , boolean[] vis) {
        if(src == dest) {
            return true;
        }

        vis[src] = true;

        for(int i : graph.get(src)) {
            if(!vis[i] && hasPath(graph , i , dest , vis))
                return true;
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return hasPath(graph , source , destination , new boolean[n]);
    }
}