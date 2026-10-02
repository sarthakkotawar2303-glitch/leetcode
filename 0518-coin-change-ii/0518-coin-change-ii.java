class Solution {

    //recursive Approach
    public int recursiveApproach(int idx, int amt, int[] coins) {
        if (amt == 0)
            return 1;
        if (idx == 0) {
            if (amt % coins[0] == 0)
                return 1;
            return 0;
        }

        int not_take = recursiveApproach(idx - 1, amt, coins);
        int take = 0;
        if (coins[idx] <= amt) {
            take = recursiveApproach(idx, amt - coins[idx], coins);
        }
        return take + not_take;
    }

    int[][] dp;

    //memorization
    public int memorization(int idx, int amt, int[] coins) {
        if (amt == 0)
            return 1;
        if (idx == 0) {
            if (amt % coins[0] == 0)
                return 1;
            return 0;
        }
        if (dp[idx][amt] != -1)
            return dp[idx][amt];

        int not_take = memorization(idx - 1, amt, coins);
        int take = 0;
        if (coins[idx] <= amt) {
            take = memorization(idx, amt - coins[idx], coins);
        }
        return dp[idx][amt] = take + not_take;
    }

    //tabulation
    public int tabulation(int amount, int[] coins) {
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int not_take = dp[i - 1][j];
                int take = 0;
                if (coins[i] <= j) {
                    take = dp[i][j - coins[i]];
                }
                 dp[i][j] = take + not_take;
            }
        }

        return dp[coins.length-1][amount];

    }

    public int change(int amount, int[] coins) {
        // Recursive Approach
        // return recursiveApproach(coins.length - 1, amount, coins);

        dp = new int[coins.length][amount + 1];
        // for (int i = 0; i < coins.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        //return memorization(coins.length - 1, amount, coins);
        return tabulation(amount,coins);
    }
}