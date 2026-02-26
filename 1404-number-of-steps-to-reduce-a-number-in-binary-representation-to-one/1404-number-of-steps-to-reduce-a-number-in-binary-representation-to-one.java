class Solution {

    public int numSteps(String s) {
        return solve(s, 0);
    }

    private int solve(String s, int count) {

        // Base case
        if (s.equals("1")) {
            return count;
        }

        int len = s.length();

        // If even → last bit = 0
        if (s.charAt(len - 1) == '0') {

            // divide by 2 → remove last bit
            return solve(s.substring(0, len - 1), count + 1);

        } else {

            // odd → add 1
            String added = addOne(s);
            return solve(added, count + 1);
        }
    }

    // binary addition helper
    private String addOne(String s) {

        StringBuilder sb = new StringBuilder(s);
        int i = sb.length() - 1;

        while (i >= 0 && sb.charAt(i) == '1') {
            sb.setCharAt(i, '0');
            i--;
        }

        if (i >= 0) {
            sb.setCharAt(i, '1');
        } else {
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}