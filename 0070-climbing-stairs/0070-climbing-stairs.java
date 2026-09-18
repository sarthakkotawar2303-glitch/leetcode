class Solution {
    int[] dp;

    public int compute(int n){

        if(n==2) return 2;
        if(n==1) return 1;

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n]=compute(n-1)+compute(n-2);

    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        return compute(n);
    }
}