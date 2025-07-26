class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    int first = res.get(i-1).get(j-1);
                    int second = res.get(i-1).get(j);
                    int sum = first + second;
                    list.add(sum);
                }
            }
            res.add(list);
        }
        return res;
    }
}