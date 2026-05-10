class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)  
            adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        boolean[] vis = new boolean[n];
        for(int i = 0; i < pre.length; i++) {
            int u = pre[i][0];
            int v = pre[i][1];

            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
         
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                vis[i] = true;
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for(int ele : adj.get(curr)) {
                indegree[ele]--;
                if(indegree[ele] == 0) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }

        return res.size() == n;
    }
}