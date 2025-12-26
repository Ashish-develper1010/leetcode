class Solution {
    public int bestClosingTime(String customers) {
        int score = 0 , maxScore = 0 , hour = 0;

        for(int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            if(ch == 'Y') score++;
            else score--;

            if(score > maxScore) {
                maxScore = score;
                hour = i+1;
            }
        }
        return hour;
    }
}