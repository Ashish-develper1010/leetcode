class Solution {
    public int numSteps(String s) {
        int num = Integer.parseInt(s,2);
        if(num <= 1) return 0;
        int count = 0;

        while(num != 1) {
            if(num % 2 != 0) num++;
            else num /= 2;
            count++;
        }

        return count;
    }
}