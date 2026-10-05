class Solution {
    int max = 0;
    int[][]dp;

    public int recursiveAppraoch(int i, int j, String s1, String s2) {
        if (i == s1.length() || j == s2.length())
            return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + recursiveAppraoch(i + 1, j + 1, s1, s2);
        }
        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j] = Math.max(recursiveAppraoch(i + 1, j, s1, s2), recursiveAppraoch(i, j + 1, s1, s2));

    }

    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return recursiveAppraoch(0, 0, text1, text2);
    }
}