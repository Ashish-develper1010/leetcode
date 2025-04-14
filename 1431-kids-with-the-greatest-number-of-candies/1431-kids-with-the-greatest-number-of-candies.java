class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> res = new ArrayList<>();

        for(int i = 0 ;i < n; i++)
        {
            int sum = candies[i]+extraCandies;
            int max = 0;
            for(int j = 0; j < n; j++)
            {
                max = Math.max(max ,candies[j] );
            }
            if(sum<max) res.add(false);
            else res.add(true);
        }
        return res;
    }
}