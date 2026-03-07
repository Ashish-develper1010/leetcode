class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;

        int diff1 = 0; // mismatch with 010101...
        int diff2 = 0; // mismatch with 101010...

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            // pattern 1 -> 010101
            if (c != (i % 2 == 0 ? '0' : '1')) diff1++;

            // pattern 2 -> 101010
            if (c != (i % 2 == 0 ? '1' : '0')) diff2++;

            // remove leftmost char when window > n
            if (i >= n) {
                char left = t.charAt(i - n);

                if (left != ((i - n) % 2 == 0 ? '0' : '1')) diff1--;
                if (left != ((i - n) % 2 == 0 ? '1' : '0')) diff2--;
            }

            // check window of size n
            if (i >= n - 1) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}