class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num , map.getOrDefault(num , 0)+1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int ele = 0;

        for(int num : map.keySet()) {
            if(map.get(num) > maxFreq) {
                maxFreq = map.get(num);
                ele = num;
            }
        } 

        int count = 0;
        int n = 0;
        for(int i = 0; i < nums.size()-1; i++) {
            if(nums.get(i) == ele) {
                count++;
            }
            n++;
            if(n / 2 < count && (nums.size() - n) / 2 < (maxFreq - count)) return i;
        }
        return -1;
    }
}