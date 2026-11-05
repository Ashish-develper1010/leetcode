class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        for(int num : arr1) {
            for(int i = 0; i < arr2.length; i++) {
                int diff = Math.abs(num - arr2[i]);
                if(diff <= d) break;
                if(i == arr2.length - 1) count++;
            }
        }
        return count;
    }
}