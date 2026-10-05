class Solution {
    int[][]dp;
     public int recursiveAppraoch(int i, int j, String s) {
        
        if(i>=j) return 0;

        if (s.charAt(i) == s.charAt(j)) {
            return recursiveAppraoch(i + 1, j - 1, s);
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = Math.min(1+recursiveAppraoch(i + 1, j, s), 1+recursiveAppraoch(i, j - 1, s));

    }
    public int minInsertions(String s) {
        int n=s.length();
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
            
        }
        return recursiveAppraoch(0,n-1,s);
    }
}