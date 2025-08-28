class Solution {
    public int[][] sortMatrix(int[][] grid) {

        int rowLen = grid.length;
        int[][] ans = new int[rowLen][rowLen];

        for(int i = 0 ; i < rowLen; i++) {
            List<Integer> list = new ArrayList<>();
            int row = i;
            int col = 0;
            while(row < rowLen) {
                list.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(list , (a , b) -> Integer.compare(b , a));
            row = i ; col = 0;

            for(int val : list) {
                ans[row][col] = val;
                row++;
                col++;
            }
        }
        
        for(int i = 1 ; i < rowLen; i++) {
            List<Integer> list = new ArrayList<>();
            int row = 0;
            int col = i;
            while(row < rowLen && col < rowLen) {
                list.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            row = 0 ; col = i;
            for(int val : list) {
                ans[row][col] = val;
                row++;
                col++;
            }
        }


        
        return ans;
    }
}