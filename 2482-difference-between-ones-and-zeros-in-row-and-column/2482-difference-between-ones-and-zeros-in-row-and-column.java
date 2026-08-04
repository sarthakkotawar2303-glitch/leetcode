class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] oneRow = new int[grid.length];
        int[] oneCol = new int[grid[0].length];

        int[] zeroRow = new int[grid.length];
        int[] zeroCol = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    oneRow[i]++;
                    oneCol[j]++;
                } else {
                    zeroRow[i]++;
                    zeroCol[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]=(oneRow[i]+oneCol[j])-(zeroRow[i]+zeroCol[j]);
            }
        }
        return grid;
    }
}