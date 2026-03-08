class Solution {

    public String flip(int i , String str) {
        StringBuilder sb = new StringBuilder(str);
        if(sb.charAt(i) == '1')
            sb.setCharAt(i , '0');
        else sb.setCharAt(i , '1');
        return sb.toString();
    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(String str : nums) set.add(str);


        for(int i = 0; i < nums.length; i++) {
            String s = flip(i , nums[i]);
            if(!set.contains(s)) return s;
        }

        return "";
    }
}