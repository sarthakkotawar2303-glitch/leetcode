class Solution {
    int[][] dp;

    //Memorization
    public int memorization(int idx, int amt, int[] coins) {

        if (amt == 0)
            return 0;

        if (idx == 0) {
            if (amt % coins[0] == 0)
                return amt / coins[0];

            return Integer.MAX_VALUE;
        }
        if(dp[idx][amt]!=-2) return dp[idx][amt];

        int not_take = memorization(idx - 1, amt, coins);

        int take = Integer.MAX_VALUE;

        if (coins[idx] <= amt) {

            int result = memorization(idx, amt - coins[idx], coins);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        return dp[idx][amt]=Math.min(take, not_take);
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

    public int coinChange(int[] coins, int amount) {
        // int result = recursiveApproach(coins.length - 1, amount, coins);

        dp=new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-2);
        }
        int result = memorization(coins.length - 1, amount, coins);

        if (result == Integer.MAX_VALUE)
            return -1;

        return result;
    }
}