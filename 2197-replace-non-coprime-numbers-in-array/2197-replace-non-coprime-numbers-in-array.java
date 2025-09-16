class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            int a = st.peek();
            int b = nums[i];
            int gcdIs = gcd(a , b);
            if(gcdIs > 1) {
                int lcmIs = lcm(gcdIs , a*b);
                st.pop();
                st.push(lcmIs);
            }
            else {
                st.push(nums[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) {
            res.add(st.pop());
        }
        Collections.reverse(res);
        return res;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b; 
            a = temp;
        }
        return a;
    }
    public int lcm(int a , int b) {
        return b / a;
    }
}