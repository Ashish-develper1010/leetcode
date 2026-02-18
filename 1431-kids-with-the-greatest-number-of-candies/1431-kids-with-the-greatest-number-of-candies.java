class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        int max = 0;
        for(int num : candies) {
            max = Math.max(max , num);
        }

        ArrayList<Boolean> res = new ArrayList<>();

        for(int i = 0; i < len; i++) {
            if((candies[i] + extraCandies) >= max) res.add(true);
            else res.add(false);
        }
        return res;
    }
}