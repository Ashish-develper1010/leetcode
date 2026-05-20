class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        if(len != B.length) return new int[0];
        int[] ans = new int[len];

        for(int i = 0; i < len; i++) {
            int j = 0;
            int count = 0;
            while( j <= i) {
                for(int k = 0; k <= i; k++) {
                    if(A[j] == B[k]) count++;
                }
                j++;
            }
            ans[i] = count;
        }

        return ans;
    }
}