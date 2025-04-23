class Solution {
    public void findAll(List<List<Integer>> ans , List<Integer> result , int i , int n , int[] nums ){
        if(i == n ) {
            ans.add(new ArrayList(result)) ; 
            return ; 
        }
        result.add(nums[i]) ; 
        findAll(ans , result , i + 1 , n , nums ) ; 
        result.remove(result.size() - 1 ) ;
        findAll(ans , result , i+ 1 , n , nums ) ; 
    }   public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ; 
        List<Integer> result = new ArrayList<>() ; 
        int i = 0 , n = nums.length ; 
        findAll(ans , result , i , n , nums ) ; 
        return ans ; 
    }
}