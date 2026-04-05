class Solution {
    public boolean judgeCircle(String moves) {
        int len = moves.length();
        int[] arr = new int[len];

        int countLeft = 0, countUp = 0;

        for(int i = 0; i < len; i++) {
            if(moves.charAt(i) == 'R') countLeft--;
            else if(moves.charAt(i) == 'U') countUp++;
            else if(moves.charAt(i) == 'D') countUp--;
            else if(moves.charAt(i) == 'L') countLeft++;
            else return false;
        }

        // int totalSum = 0;

        // for(int num : arr) {
        //     totalSum += num;
        // }
        
        return countLeft == 0 && countUp == 0;
    }
}