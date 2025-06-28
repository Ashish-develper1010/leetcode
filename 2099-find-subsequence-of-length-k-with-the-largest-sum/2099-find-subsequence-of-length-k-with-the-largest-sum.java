class Solution {
    class pair {
        int first ;
        int second ;

        public pair(int f , int s) {
            this.first = f;
            this.second = s;
        }
    }
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a , b) -> Integer.compare(a.first , b.first));
        ArrayList<pair> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            pq.add(new pair(nums[i] , i));
            if(pq.size() > k) pq.poll();
        }

        while(!pq.isEmpty()) {
            pair p = pq.poll();
            int fir = p.first;
            int sec = p.second;

            list.add(new pair(fir , sec));
        }

        Collections.sort(list , (a , b) -> Integer.compare(a.second,b.second));

        int[] res = new int[k];
        int i = 0;

        for(pair p : list) {
            int fir = p.first;
            res[i++] = fir;
        }
        return res;
     }
}