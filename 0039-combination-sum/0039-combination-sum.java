class Solution {
    public void helper(int[] candidates , int target , List<List<Integer>> res , List<Integer> ans , int idx) {
        if(target == 0) {
            res.add(new ArrayList(ans));
            return;
        }
        if(target < 0) return;

        for(int i = idx; i < candidates.length; i++) {
            ans.add(candidates[i]);
            helper(candidates , target - candidates[i] , res , ans , i);
            ans.remove(ans.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(candidates , target , res , ans , 0);
        return res;
    }
}