class Solution {
    public int findSmaller(int[][] matrix , int mid) {
        int smallerele = 0;
        for(int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length-1;
            while(start <= end) {
                int midi = start + (end - start) / 2;
                if(matrix[i][midi] <= mid) {
                    start = midi+1;
                }
                else end = midi-1;
            }
            smallerele += start;
        }
        return smallerele;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = matrix[0][0];
        int end = matrix[n-1][m-1];
        int midIdx = k-1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            int lesserElement = findSmaller(matrix , mid);
            if(lesserElement <= midIdx) {
                start = mid+1;
            }
            else end = mid;
        }
        return start;
    }
}