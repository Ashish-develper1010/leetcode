class Solution {
    public double new21Game(int N, int K, int maxPts) {
        if (K == 0 || N >= K - 1 + maxPts) return 1.0; 
        // If Alice never needs to draw OR max possible score is ≤ N → probability = 1

        double[] dp = new double[N + 1];
        dp[0] = 1.0;
        double windowSum = 1.0; // sum of last maxPts dp values
        double result = 0.0;

        for (int i = 1; i <= N; i++) {
            dp[i] = windowSum / maxPts; // probability for i

            if (i < K) {
                windowSum += dp[i]; // still drawing
            } else {
                result += dp[i]; // stopped, count in result
            }

            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts]; // slide window
            }
        }

        return result;
    }
}
