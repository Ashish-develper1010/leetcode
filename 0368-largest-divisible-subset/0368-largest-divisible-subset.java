class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if(arr.length == 1) {
            list.add(arr[0]);
            return list;
        }
        for(int i = 0 ; i < arr.length; i++) {
            for(int j = i+1; i < arr.length; i++) {
                if(arr[i] % arr[j] == 0 || arr[j] % arr[i] == 0) {
                    list.add(arr[i]);
                }
            }
        }
        return list;
    }
}