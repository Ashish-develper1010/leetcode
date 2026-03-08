class Solution {
    static String answer;
    private void generate(StringBuilder sb, HashSet<String> set, int n) {
        if(answer.length() != 0) return;
        if(sb.length() == n) {
            if(!set.contains(sb.toString())) answer = sb.toString();
            return ;
        }

        // Add 0
        sb.append("0");
        generate(sb, set, n);
        // Remove last 
        sb.deleteCharAt(sb.length() - 1);
        // Add 1
        sb.append("1");
        generate(sb, set, n);

        sb.deleteCharAt(sb.length() - 1);

    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        // String sb = "";
        for(String s : nums) {
            set.add(s);
        }

        answer = "";
        generate(sb,set,nums.length);
        return answer;
    }
}