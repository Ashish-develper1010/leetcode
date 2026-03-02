class Solution {
    public int minSwaps(int[][] grid) {
        
        int ansCount = 0;
        int n = grid.length;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int countZero = 0;
            for(int j = n-1; j >= 0; j--) {
                if(grid[i][j] != 0) break;
                countZero++;
            }

            arr[i] = countZero;
        }


        for(int i = 0; i < n; i++) {
            if(arr[i] >= n-1-i) continue;
            int maxIdx = i;

            for(int j = i+1; j < n; j++) {
                if(arr[j] >= n -1- i) {
                    maxIdx = j;
                    break;
                }
            }

            ansCount += maxIdx - i;
            arrange(arr, i , maxIdx);
        }

        for(int i = 0; i < n; i++) {
            if(arr[i] < n - i -1) return -1;
        }

        return ansCount;

    }

    public void arrange(int[] arr , int i , int j) {
        for(int k = j - 1; k >= i; k--) {
            int temp = arr[k];
            arr[k] = arr[k+1];
            arr[k+1] = temp;
        }
    }
}