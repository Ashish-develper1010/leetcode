class Solution {
    public int minMaxDifference(int num) {
        String str = String.valueOf(num);

        // --- Get max value ---
        char maxDigitToReplace = '\0';
        for (char c : str.toCharArray()) {
            if (c != '9') {
                maxDigitToReplace = c;
                break;
            }
        }
        String maxStr = (maxDigitToReplace == '\0') ? str : str.replace(maxDigitToReplace, '9');
        int maxVal = Integer.parseInt(maxStr);

        // --- Get min value ---
        char minDigitToReplace = '\0';
        for (char c : str.toCharArray()) {
            if (c != '0') {
                minDigitToReplace = c;
                break;
            }
        }
        String minStr = (minDigitToReplace == '\0') ? str : str.replace(minDigitToReplace, '0');
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }
}
