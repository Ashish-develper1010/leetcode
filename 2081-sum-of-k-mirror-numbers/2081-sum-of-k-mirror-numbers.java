class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            // Odd length palindromes
            for (int i = (int) Math.pow(10, len - 1); i < Math.pow(10, len) && count < n; i++) {
                String s = Integer.toString(i);
                String rev = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
                long val = Long.parseLong(s + rev);

                if (isKPalindrome(val, k)) {
                    sum += val;
                    count++;
                }
            }

            // Even length palindromes
            for (int i = (int) Math.pow(10, len - 1); i < Math.pow(10, len) && count < n; i++) {
                String s = Integer.toString(i);
                String rev = new StringBuilder(s).reverse().toString();
                long val = Long.parseLong(s + rev);

                if (isKPalindrome(val, k)) {
                    sum += val;
                    count++;
                }
            }

            len++;
        }

        return sum;
    }

    private boolean isKPalindrome(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        String baseK = sb.toString();
        int l = 0, r = baseK.length() - 1;
        while (l < r) {
            if (baseK.charAt(l++) != baseK.charAt(r--)) return false;
        }
        return true;
    }
}
