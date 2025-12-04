class Solution {
    public int countCollisions(String directions) {
        char[] arr = directions.toCharArray();
        int i = 0 , j = arr.length-1 , ans = 0;
        boolean left = false , right = false;

        while(i <= j) {
            while(i <= j && !left && arr[i] == 'L') i++;
            while(i <= j && !right && arr[j] == 'R') j--;
            left = true;
            right = true;

            if(i<= j && arr[i] != 'S') ans++;
            i++;
        }
        return ans;
    }
}