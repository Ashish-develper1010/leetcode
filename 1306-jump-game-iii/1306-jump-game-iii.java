class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean vis[] = new boolean[arr.length];

        while(!q.isEmpty()) {
            int curr = q.poll();
            vis[curr] = true;

            if(arr[curr] == 0) return true;

            if(curr + arr[curr] < arr.length && vis[curr + arr[curr]] == false) 
                q.offer(curr + arr[curr]);
            if(curr - arr[curr] > -1 && vis[curr - arr[curr]] == false ) 
                q.offer(curr - arr[curr]);
        }

        return false;
    }
}