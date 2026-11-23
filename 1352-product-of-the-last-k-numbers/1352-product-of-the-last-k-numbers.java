import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1); // sentinel so the first product divides cleanly
    }

    public void add(int num) {
        if (num == 0) {
            // any product spanning this zero is 0, so start fresh
            prefix.clear();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = prefix.size();
        // fewer than k numbers since the last zero means a zero is in the window
        if (k >= n) return 0;
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}