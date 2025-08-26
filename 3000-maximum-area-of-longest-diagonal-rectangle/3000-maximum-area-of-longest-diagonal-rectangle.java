class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int[] max = new int[2];
        int maxArea = Integer.MIN_VALUE;
        double maxDiagonal = Integer.MIN_VALUE;

        for(int i = 0 ; i < dimensions.length; i++) {
            double diagonal = Math.sqrt(dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1]);
            if(diagonal >= maxDiagonal) {
                maxDiagonal = diagonal;
                max = dimensions[i];
                maxArea = Math.max(maxArea , max[0] * max[1]);
            }
        }

        return maxArea;
    }
}