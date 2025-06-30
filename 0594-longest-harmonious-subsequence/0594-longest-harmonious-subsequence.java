class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num , map.getOrDefault(num , 0)+1);
        }
        int max = 0 , sum = 0;
        for(int num : map.keySet()) {
            if(map.containsKey(num+1)) {
                sum = map.get(num) + map.get(num+1);
            }
            max = Math.max(max , sum);
        }
        return max;
    }
}