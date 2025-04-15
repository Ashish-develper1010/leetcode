class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            if(i==0 || arr[i-1]!=arr[i])
            {
                twoSumSorted(i+1,arr.length-1,0-arr[i],arr);
            }
        }
        return res;
    }
    

    void twoSumSorted(int i,int j,int target,int[] arr)
    {
        int a = arr[i-1];
        while(i<j)
        {
            if(arr[i]+arr[j]>target)
            {
                j--;
            }
            else if(arr[i]+arr[j]<target)
            {
                i++;
            }
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                list.add(arr[i]);
                list.add(arr[j]);

                res.add(list);

                while(i<j && arr[i]==arr[i+1]) i++;
                while(i<j && arr[j]==arr[j-1]) j--;

                i++;
                j--;
            }
        }
    }
}