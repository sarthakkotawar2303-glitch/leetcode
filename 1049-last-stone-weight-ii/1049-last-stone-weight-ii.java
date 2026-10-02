class Solution {
    int[][] dp;

    //tabulation
    public int tabulation(int target, int[] stones) {
        for (int i = 0; i <= target; i++) {
            if (stones[0] <= i) {
                dp[0][i] = stones[0];
            }
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j <= target; j++) {
                int not_take = dp[i - 1][j];
                int take = 0;

                if (stones[i] <= j) {
                    take = stones[i] + dp[i - 1][j - stones[i]];
                }

                 dp[i][j] = Math.max(take, not_take);
            }
        }

        return dp[stones.length-1][target];
    }

    //memorization
    public int memorization(int idx, int target, int[] stones) {
        if (idx == 0) {
            if (stones[idx] <= target) {
                return stones[idx];
            }
            return 0;
        }

        if (dp[idx][target] != -1)
            return dp[idx][target];

        int not_take = memorization(idx - 1, target, stones);
        int take = 0;

        if (stones[idx] <= target) {
            take = stones[idx] + memorization(idx - 1, target - stones[idx], stones);
        }

        return dp[idx][target] = Math.max(take, not_take);
    }

    //recursiveAppraoch
    public int recursiveAppraoch(int idx, int target, int[] stones) {
        if (idx == 0) {
            if (stones[idx] <= target) {
                return stones[idx];
            }
            return 0;
        }
        int not_take = recursiveAppraoch(idx - 1, target, stones);
        int take = 0;

        if (stones[idx] <= target) {
            take = stones[idx] + recursiveAppraoch(idx - 1, target - stones[idx], stones);
        }

        return Math.max(take, not_take);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int target = sum / 2;
        int n = stones.length;

        // int result = recursiveAppraoch(n - 1, target, stones);

        dp = new int[stones.length][target + 1];
        // for (int i = 0; i < stones.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // int result = memorization(n - 1, target, stones);

        int result=tabulation(target,stones);

        return sum - 2 * result;
    }
}