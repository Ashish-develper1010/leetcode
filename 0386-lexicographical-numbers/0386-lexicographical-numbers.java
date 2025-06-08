class Solution {
    private void solve(int curr , int n , List<Integer> list) {
        if(curr > n) return ;
        list.add(curr);
        
        for(int append = 0; append <= 9; append++) {
            int newnum = curr*10 + append;
            solve(newnum , n , list);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            solve(i , n , list);
        }
        return list;
    }
}