/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int min = 1;
        int max = n;

        while(min <= max) {
            int mid = min + (max - min ) / 2;
            if(isBadVersion(mid)) max = mid-1;
            else min = mid+1;
        }
        return min;

    }
}