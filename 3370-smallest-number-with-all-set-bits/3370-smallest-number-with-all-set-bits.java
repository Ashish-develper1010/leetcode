class Solution {
    public int smallestNumber(int n) {
        

        int diff = Integer.MAX_VALUE;
        int pre = 0;
        int i = 1;
        while(true) {
            if(n <= i) {
                if(diff > i - n) {
                    pre = i;
                    diff = i - n;
                }
                else return pre;
            }

            i = i * 2 + 1;
        }
        // return 0;
    }
}