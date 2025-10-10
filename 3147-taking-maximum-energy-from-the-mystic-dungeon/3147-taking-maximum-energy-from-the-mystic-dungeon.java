class Solution {
    public int maximumEnergy(int[] energy, int k) {
        for(int i = energy.length - 1 - k; i >= 0; i--) {
            energy[i] += energy[i+k];
        }

        int max = Integer.MIN_VALUE;
        for(int ele : energy) {
            max = Math.max(max,ele);
        }
        return max;
    }
}