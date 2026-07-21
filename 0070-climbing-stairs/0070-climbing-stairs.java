class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return totalWays(n, memo);
    }
    
    private int totalWays(int n, int[] memo) {
        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // Check if value was already calculated
        if (memo[n] != 0) {
            return memo[n];
        }
        
        // Save result to cache before returning
        memo[n] = totalWays(n - 1, memo) + totalWays(n - 2, memo);
        return memo[n];
    }
}
