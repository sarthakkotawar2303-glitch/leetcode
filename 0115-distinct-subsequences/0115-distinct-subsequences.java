class Solution {
    int[][] dp;

    public int recursiveAppraoch(int i, int j, String s, String t) {
        if (j == t.length())
            return 1;

        if (i == s.length())
            return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];

        if (s.charAt(i) != t.charAt(j))
            return recursiveAppraoch(i + 1, j, s, t);

        int take = recursiveAppraoch(i + 1, j + 1, s, t);
        int not_take = recursiveAppraoch(i + 1, j, s, t);

        return dp[i][j]=take + not_take;

    }

    public int numDistinct(String s, String t) {
        dp=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)Arrays.fill(dp[i],-1);
        return recursiveAppraoch(0, 0, s, t);
    }
}