class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> res  = new ArrayList<>();
        for(int i=0;i<arr.length;++i)
        {
            int index = Math.abs(arr[i])-1;
            if(arr[index]<0)
            {
                res.add(Math.abs(arr[i]));
            }
            arr[index] = -arr[index];
        }
        return res;
    }
}