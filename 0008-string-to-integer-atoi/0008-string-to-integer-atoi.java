class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;
        if (i == n) return 0;

        // Step 2: Handle optional sign
        boolean isNegative = false;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            isNegative = s.charAt(i) == '-';
            i++;
        }

        // Step 3: Convert digits
        long res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');
            if (res > Integer.MAX_VALUE) break;  // prevent overflow
            i++;
        }

        // Step 4: Apply sign
        if (isNegative) res = -res;

        // Step 5: Clamp within int range
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) res;
    }
}
