class Solution {

    int[][] dp;

    public int recursiveAppraoch(int i, int j, String s1, String s2) {
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;


        if (s1.charAt(i) == s2.charAt(j)) {
            return recursiveAppraoch(i + 1, j + 1, s1, s2);
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = Math.min(1+recursiveAppraoch(i + 1, j, s1, s2), 1+recursiveAppraoch(i, j + 1, s1, s2));

    }
    public int minDistance(String word1, String word2) {
                dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return recursiveAppraoch(0, 0, word1, word2);
    }
}