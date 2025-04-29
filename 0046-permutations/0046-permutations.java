class Solution {
    public void swap(int[] nums , int x , int y) {
        int temp = nums[x] ;
        nums[x] = nums[y]; 
        nums[y] = temp;
    }
    public void perm(int[] nums , int idx , List<List<Integer>> res) {
        if(idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int num : nums) {
                temp.add(num);
            } 
            res.add(new ArrayList(temp));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            swap(nums , i , idx);
            perm(nums , idx+1 , res);
            swap(nums , i , idx);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(nums , 0 , res);
        return res;
    }
}