class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];

        // Build length array
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '#') {
                len[i + 1] = Math.min(Long.MAX_VALUE / 2, len[i] * 2);
            } else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (ch == '%') {
                len[i + 1] = len[i];
            } else {
                len[i + 1] = len[i] + 1;
            }
        }

        if (k < 0 || k >= len[n]) {
            return '.';
        }

        // Trace kth character backwards
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = len[i];

            if (ch == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (ch == '*') {
                // Deleted last char, kth position unaffected
            } else if (ch == '%') {
                k = prevLen - 1 - k;
            } else {
                if (k == prevLen) {
                    return ch;
                }
            }
        }

        return '.';
    }
}