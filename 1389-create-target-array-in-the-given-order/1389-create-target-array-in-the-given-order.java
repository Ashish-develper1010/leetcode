class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0;  i < index.length; i++) {
            list.add(index[i] , nums[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}