class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int len = nums.length;
        long[] prefix = new long[len];
        prefix[0] = nums[0];

        for(int i = 1; i < len; i++) {
            prefix[i] = (prefix[i-1] * 2 + nums[i])%5;
        }
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            if(prefix[i] % 5 != 0) res.add(false);
            else res.add(true);
        }
        return res;

    }
}