// RECURSIVE APPRAOCH :- BUT TIME LIMITS OCCURS

// class Solution {
//     public int paths(int m, int n) {

//         if(m==0 && n==0) return 1;

//         if(m<0 || n<0) return 0;

//         int down=paths(m-1,n);
//         int right=paths(m,n-1);

//         return down+right;
//     }
//     public int uniquePaths(int m, int n) {
//         return paths(m-1,n-1);
//     }
// }

// MEMORIZATION
// class Solution {
//     int[][]dp;
//     public int paths(int m, int n) {

//         if(m==0 && n==0) return 1;

//         if(m<0 || n<0) return 0;

//         if(dp[m][n]!=-1) return dp[m][n];

//         int down=paths(m-1,n);
//         int right=paths(m,n-1);

//         return dp[m][n]=down+right;
//     }
//     public int uniquePaths(int m, int n) {
//         dp=new int[m][n];

//         for(int[] arr:dp){
//              Arrays.fill(arr,-1);
//         }
//         return paths(m-1,n-1);
//     }
// }

// TABULATION

class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                int right = 0;
                int down = 0;

                if (i > 0) {
                    down = dp[i - 1][j];
                }
                if (j > 0) {
                    right = dp[i][j - 1];
                }

                dp[i][j] = right + down;
            }
        }
        return dp[m - 1][n - 1];
    }
}