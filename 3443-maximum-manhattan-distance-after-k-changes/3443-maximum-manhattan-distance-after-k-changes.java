import java.util.*;

public class Solution {

    public static int maxDistance(String s, int k) {
        int ans = 0;
        // Predefine direction sets for NE, NW, SE, SW
        List<Set<Character>> preferredDirections = List.of(
            Set.of('N', 'E'),
            Set.of('N', 'W'),
            Set.of('S', 'E'),
            Set.of('S', 'W')
        );

        for (Set<Character> preferred : preferredDirections) {
            int score = 0, remainingChanges = k;

            for (char move : s.toCharArray()) {
                if (preferred.contains(move)) {
                    score++;
                } else if (remainingChanges > 0) {
                    remainingChanges--;
                    score++;
                } else {
                    score--;
                }

                ans = Math.max(ans, score);
            }
        }

        return ans;
    }
}
