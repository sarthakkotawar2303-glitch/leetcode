class Solution {
    int[][]dp;
    public int paths(int m, int n) {
        
        if(m==0 && n==0) return 1;

        if(m<0 || n<0) return 0;

        if(dp[m][n]!=-1) return dp[m][n];

        
        int down=paths(m-1,n);
        int right=paths(m,n-1);

        return dp[m][n]=down+right;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];

        for(int[] arr:dp){
             Arrays.fill(arr,-1);
        }
        return paths(m-1,n-1);
    }
}