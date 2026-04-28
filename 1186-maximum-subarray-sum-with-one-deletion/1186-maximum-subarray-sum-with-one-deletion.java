class Solution {
    public int maximumSum(int[] arr) {
        int oneDeletion = 0;
        int noDeletion = arr[0];
        int ans = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int prevNoDeletion = noDeletion;
            
            noDeletion = Math.max(noDeletion + arr[i] , arr[i]);
            oneDeletion = Math.max(oneDeletion + arr[i] , prevNoDeletion);

            ans = Math.max(ans , Math.max(noDeletion , oneDeletion));
        }

        return ans;
    }
}