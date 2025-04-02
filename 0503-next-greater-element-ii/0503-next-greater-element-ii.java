class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                ans[st.peek()] = nums[i];
                st.pop();
            }
            st.push(i);
        }

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                ans[st.peek()] = nums[i];
                st.pop(); 
            }
        }

        while(!st.isEmpty()) {
            ans[st.peek()] = -1;
            st.pop();
        }

        return ans;
    }
}