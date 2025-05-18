class Solution {
    public void helper(int n , int open , int close , String str , List<String> list) {
        if(str.length() == 2*n) {
            list.add(str);
            return ;
        }
        if(open > 0) {
            helper(n , open -1 , close , str+"(", list);
        }
        if(open < close) {
            helper(n , open , close-1 , str+")" , list);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String str = "";
        helper(n , n , n , str , list);
        return list;
    }
}