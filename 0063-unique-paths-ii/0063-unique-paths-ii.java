//RECURSIVE APPRAOCH --> TIME LIMIT EXCEEDS

// class Solution {

//     public int paths(int n, int m, int[][] obstacleGrid) {

//         if (m < 0 || n < 0)
//             return 0;

//         if (obstacleGrid[n][m] == 1)
//             return 0;

//         if (m == 0 && n == 0)
//             return 1;

//         int down = paths(n - 1, m, obstacleGrid);
//         int right = paths(n, m - 1, obstacleGrid);

//         return down + right;
//     }

//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {

//         int n = obstacleGrid.length;
//         int m = obstacleGrid[0].length;
//         if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1)
//             return 0;
//         return paths(n - 1, m - 1, obstacleGrid);
//     }
// }

class Solution {

    int[][] dp;

    public int paths(int n, int m, int[][] obstacleGrid) {

        if (m < 0 || n < 0)
            return 0;

        if (obstacleGrid[n][m] == 1)
            return 0;

        if (m == 0 && n == 0)
            return 1;
        
        if(dp[n][m]!=-1) return dp[n][m];

        int down = paths(n - 1, m, obstacleGrid);
        int right = paths(n, m - 1, obstacleGrid);

        return dp[n][m]=down + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1)
            return 0;
       
        dp=new int[n][m];

        for(int[] arr:dp){
             Arrays.fill(arr,-1);
        }
        
        return paths(n - 1, m - 1, obstacleGrid);
    }
}