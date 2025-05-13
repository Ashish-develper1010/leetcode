import java.util.Arrays;

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        int[] count = new int[26];

        // Initialize the count array with the frequency of each character in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Perform t transformations
        for (int step = 0; step < t; step++) {
            int[] newCount = new int[26];
            for (int i = 0; i < 25; i++) {
                newCount[i + 1] = count[i];
            }
            // Handle 'z' transformation: 'z' -> 'a' and 'b'
            newCount[0] = (newCount[0] + count[25]) % MOD;
            newCount[1] = (newCount[1] + count[25]) % MOD;
            count = newCount;
        }

        // Sum all character counts to get the total length
        int totalLength = 0;
        for (int c : count) {
            totalLength = (totalLength + c) % MOD;
        }

        return totalLength;
    }
}
