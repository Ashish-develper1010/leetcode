class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while(i < s.length()) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < k; j++) {
                if(i < s.length()) {
                    sb.append(s.charAt(i));
                    i++;
                }
                else {
                    sb.append(fill);
                }
            }
            list.add(sb.toString());
        }
        return list.toArray(new String[0]);
    }
}