class Solution {
    public String triangleType(int[] arr) {
        if(arr[0] == arr[1] && arr[1] == arr[2]) return "equilateral";
        if(arr[0] + arr[1] > arr[2] && arr[0] + arr[2] > arr[1] && arr[1] + arr[2] > arr[0]) {
            if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) return "isosceles";
            else return "scalene";
        }
        return "none";
    }
}