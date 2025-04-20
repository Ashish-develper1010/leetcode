

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int ans : answers) {
            if (ans == 0) {
                res++; // A single rabbit that sees no others of its color
                continue;
            }
            map.put(ans, map.getOrDefault(ans, 0) + 1);
            
            // If the count reaches ans+1, that means we have counted a full group
            if (map.get(ans) == ans + 1) {
                res += ans + 1;
                map.remove(ans); // Remove the completed group
            }
        }

        // Add the remaining rabbits that haven't formed a complete group
        for (int num : map.keySet()) {
            res += num + 1;
        }

        return res;
    }
}
