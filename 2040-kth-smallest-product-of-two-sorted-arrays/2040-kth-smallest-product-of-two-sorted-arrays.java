class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L, high = 10000000000L;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countLessEqual(nums1, nums2, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private long countLessEqual(int[] A, int[] B, long x) {
        long count = 0;

        for (int a : A) {
            if (a == 0) {
                if (x >= 0) count += B.length;
                // else 0 * b > x → contributes nothing
            } else if (a > 0) {
                // want b ≤ x / a
                int left = 0, right = B.length;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if ((long)a * B[mid] <= x) left = mid + 1;
                    else right = mid;
                }
                count += left;
            } else { // a < 0
                // want b ≥ ceil(x / a)
                int left = 0, right = B.length;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if ((long)a * B[mid] <= x) right = mid;
                    else left = mid + 1;
                }
                count += B.length - left;
            }
        }

        return count;
    }
}
