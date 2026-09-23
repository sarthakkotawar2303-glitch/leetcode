class Solution {

    int[][] dp;

    public int paths(int r, int c, int[][] matrix, int n, int m) {

        if (c < 0 || c >= m)
            return (int) 1e8;

        if (r == 0)
            return matrix[0][c];

        if(dp[r][c]!=Integer.MAX_VALUE) return dp[r][c];

        int left = matrix[r][c] + paths(r - 1, c - 1, matrix, n, m);
        int right = matrix[r][c] + paths(r - 1, c + 1, matrix, n, m);
        int down = matrix[r][c] + paths(r - 1, c, matrix, n, m);

        return dp[r][c]=Math.min(left, Math.min(right, down));

    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int currentSum = Integer.MAX_VALUE;

        dp=new int[n][m];
        for(int[]arr:dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        for (int j = 0; j < m; j++) {
            currentSum = Math.min(currentSum, paths(n - 1, j, matrix, n, m));
        }
        return currentSum;
    }
}