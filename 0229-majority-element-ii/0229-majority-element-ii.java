class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        int cand1 = 0, cand2 = 0;
        int cnt1 = 0, cnt2 = 0;

        for(int num : nums) {
            if(num == cand1) cnt1++;
            else if(num == cand2) cnt2++;
            else if(cnt1 == 0) {
                cand1 = num;
                cnt1++;
            }
            else if(cnt2 == 0) {
                cand2 = num;
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;

        for(int num : nums) {
            if(num == cand1) cnt1++;
            else if(num == cand2) cnt2++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        if(cnt1 > nums.length / 3) list.add(cand1);
        if(cnt2 > nums.length / 3) list.add(cand2);
        return list;
    }
}