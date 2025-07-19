class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        HashSet<String> set = new HashSet<>();
        boolean update = false;
        for(String str : folder) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(i < str.length()) {
                if(!set.contains(sb.toString())) {
                    update = true;
                    sb.append(str.charAt(i));
                    i++;
                    while(i < str.length() && str.charAt(i) != '/') {
                        sb.append(str.charAt(i));
                        i++;
                    }
                }
                else {
                    update = false;
                    i++;
                    break;
                }
            }
            if(update) {
                set.add(sb.toString());
            }
        }
        List<String> res = new ArrayList<>(set);
        return res;
    }
}