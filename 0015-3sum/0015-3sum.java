class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threesum = new ArrayList<>();
        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        // Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            int target = -nums[i];

            while(j < k) {
                
                int sum = nums[j] + nums[k];
                if(sum == target) {
                    threesum.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }
                else if(sum < target) j++;
                else k--;
            }
        }
        return threesum;
        
    }
}