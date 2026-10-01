class Solution {
    int[][] dp;

    //main
    public int coinChange(int[] coins, int amount) {

        // int result = recursiveApproach(coins.length - 1, amount, coins);

        dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -2);
        }
        // int result = memorization(coins.length - 1, amount, coins);

        // if (result == Integer.MAX_VALUE)
        //     return -1;

        // return result;

        return tabulation(coins, amount);
    }

    public int tabulation(int[] coins, int amount) {

        // Base case: amount 0 requires 0 coins
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        // Base case: using only the first coin
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < coins.length; i++) {

            for (int j = 1; j <= amount; j++) {

                // Not take
                int not_take = dp[i - 1][j];

                // Take
                int take = Integer.MAX_VALUE;

                if (coins[i] <= j) {

                    int result = dp[i][j - coins[i]];

                    if (result != Integer.MAX_VALUE) {
                        take = 1 + result;
                    }
                }

                dp[i][j] = Math.min(take, not_take);
            }
        }

        int result = dp[coins.length - 1][amount];

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    //Memorization
    public int memorization(int idx, int amt, int[] coins) {

        if (amt == 0)
            return 0;

        if (idx == 0) {
            if (amt % coins[0] == 0)
                return amt / coins[0];

            return Integer.MAX_VALUE;
        }
        if (dp[idx][amt] != -2)
            return dp[idx][amt];

        int not_take = memorization(idx - 1, amt, coins);

        int take = Integer.MAX_VALUE;

        if (coins[idx] <= amt) {

            int result = memorization(idx, amt - coins[idx], coins);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        return dp[idx][amt] = Math.min(take, not_take);
    }

    //recursive Appraoch
    public int recursiveApproach(int idx, int amt, int[] coins) {

        if (amt == 0)
            return 0;
        if (idx == 0) {
            if (amt % coins[idx] == 0)
                return amt / coins[0];
            return Integer.MAX_VALUE;
        }

        int not_take = recursiveApproach(idx - 1, amt, coins);
        int take = Integer.MAX_VALUE;
        if (coins[idx] <= amt) {
            int result = recursiveApproach(idx, amt - coins[idx], coins);

            if (result != Integer.MAX_VALUE)
                take = 1 + result;
        }

        return Math.min(take, not_take);
    }

}