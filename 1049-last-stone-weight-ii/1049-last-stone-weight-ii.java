class Solution {
    int[][] dp;

    //memorization
    public int memorization(int idx, int target, int[] stones) {
        if (idx == 0) {
            if (stones[idx] <= target) {
                return stones[idx];
            }
            return 0;
        }

        if(dp[idx][target]!=-1) return dp[idx][target];

        int not_take = memorization(idx - 1, target, stones);
        int take = 0;

        if (stones[idx] <= target) {
            take = stones[idx] + memorization(idx - 1, target - stones[idx], stones);
        }

        return dp[idx][target]=Math.max(take, not_take);
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
        for(int i=0;i<stones.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int result = memorization(n - 1, target, stones);

        return sum - 2 * result;
    }
}