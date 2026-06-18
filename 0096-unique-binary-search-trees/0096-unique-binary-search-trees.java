class Solution {
    public int numTrees(int n) {
        // STEP 1: Create a notepad big enough to hold our boundaries
        int[][] memo = new int[n + 1][n + 1];
        return combination(1, n, memo);
    }

    public int combination(int low, int high, int[][] memo) {
        if (low > high) return 1;

        // STEP 2: Check the notepad before doing heavy math loops
        if (memo[low][high] != 0) {
            return memo[low][high]; 
        }

        int totalcount = 0;
        for (int i = low; i <= high; i++) {
            int left = combination(low, i - 1, memo);
            int right = combination(i + 1, high, memo);

            totalcount += left * right;
        }

        // STEP 3: Save the answer to the notepad before returning
        memo[low][high] = totalcount; 
        return totalcount;
    }
}
