class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }

            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }

        if(grid[row][col]==0) return 0;

        grid[row][col]=0;

        return 1+ dfs(grid, row - 1, col) 
              + dfs(grid, row + 1, col) 
              + dfs(grid, row, col - 1) 
              + dfs(grid, row, col + 1);

    }
}