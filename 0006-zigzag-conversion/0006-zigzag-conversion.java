class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i = 0 ; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingdown = false;

        for(char ch : s.toCharArray()) {
            rows[currRow].append(ch);
            if(currRow == 0 || currRow == numRows - 1) goingdown = !goingdown;
            currRow += goingdown ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder st : rows) {
            sb.append(st);
        }
        return sb.toString();
    }
}