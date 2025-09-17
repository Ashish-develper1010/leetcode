import java.util.*;

class FoodRatings {
    // Map food -> cuisine
    private final Map<String, String> foodToCuisine = new HashMap<>();
    // Map food -> rating
    private final Map<String, Integer> foodToRating = new HashMap<>();
    // Map cuisine -> TreeSet of foods, ordered by (-rating, name)
    private final Map<String, TreeSet<String>> cuisineToSet = new HashMap<>();

    // comparator that uses current foodToRating map to compare names
    private Comparator<String> makeComparator() {
        return (a, b) -> {
            int ra = foodToRating.get(a);
            int rb = foodToRating.get(b);
            if (ra != rb) return Integer.compare(rb, ra); // higher rating first
            return a.compareTo(b); // lexicographically smaller first
        };
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        // initialize maps
        for (int i = 0; i < foods.length; ++i) {
            String f = foods[i], c = cuisines[i];
            int r = ratings[i];
            foodToCuisine.put(f, c);
            foodToRating.put(f, r);
        }
        // For each cuisine, create a TreeSet with comparator that reads ratings from foodToRating
        for (int i = 0; i < foods.length; ++i) {
            String f = foods[i], c = cuisines[i];
            cuisineToSet.putIfAbsent(c, new TreeSet<>(makeComparator()));
        }
        // Now populate sets (after all sets created so comparator works)
        for (String f : foods) {
            String c = foodToCuisine.get(f);
            cuisineToSet.get(c).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineToSet.get(cuisine);
        // Remove old entry, update rating, re-insert
        set.remove(food);                 // O(log m)
        foodToRating.put(food, newRating); 
        // Note: comparator reads from foodToRating, so reinsert uses updated rating
        set.add(food);                    // O(log m)
    }

    public String highestRated(String cuisine) {
        TreeSet<String> set = cuisineToSet.get(cuisine);
        return set.first(); // highest by comparator
    }
}
