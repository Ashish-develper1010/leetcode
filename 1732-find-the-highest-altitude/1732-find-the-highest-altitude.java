class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;

        for(int i = 0; i < n; i++)
        {
            prefixSum[i+1] = prefixSum[i] + gain[i];
        }

        int max = 0;
        for(int i = 0 ; i < n+1; i++)
        {
            max = Math.max(max , prefixSum[i]);
        }

        return max;
    }
}