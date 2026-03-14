class Solution {
    static ArrayList<String> list;

    public void findAll(int n, String str) {
        if(str.length() == n) {
            list.add(str);
            return;
        }

        for(char currchar = 'a'; currchar <= 'c'; currchar++) {
            if(str.length() > 0 && str.charAt(str.length() - 1) == currchar) continue;

            findAll(n, str + currchar);
        }
    }
    public String getHappyString(int n, int k) {
        list = new ArrayList<>();
        String str = "";

        findAll(n,str);

        if(list.size() < k) return "";

        // Collections.reverse(list);

        return list.get(k-1);

    }
}