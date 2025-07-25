class Solution {
    public int maxSum(int[] arr) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        if(max < 0) {
            return max;
        }
        int[] freq = new int[max+1];

        for(int ele : arr) {
            if(ele < 0) continue;
            freq[ele]++;
        }
        int sum = 0;

        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                sum += i;
            }
        }
        return sum;
    }
}