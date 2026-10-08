class Solution {
    int[][] dp;

    public int recursiveAppraoch(int i, int j, String word1, String word2) {

        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return recursiveAppraoch(i + 1, j + 1, word1, word2);
        }
        int insert = 1 + recursiveAppraoch(i, j + 1, word1, word2);

        int delete = 1 + recursiveAppraoch(i + 1, j, word1, word2);

        int replace = 1 + recursiveAppraoch(i + 1, j + 1, word1, word2);

        return dp[i][j]=Math.min(insert, Math.min(replace, delete));

    }

    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return recursiveAppraoch(0, 0, word1, word2);
    }
}