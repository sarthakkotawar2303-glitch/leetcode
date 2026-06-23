import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] pascalTable;

    public int numOfWays(int[] nums) {
        // FIXED: Defined n using .length instead of .size()
        int n = nums.length; 
        
        pascalTable = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascalTable[i][j] = 1;
                } else {
                    pascalTable[i][j] = (pascalTable[i - 1][j - 1] + pascalTable[i - 1][j]) % MOD;
                }
            }
        } 

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }

        long totalWays = dfs(list);
        return (int) ((totalWays - 1 + MOD) % MOD);
    }

    public long dfs(List<Integer> list) {
        if (list.size() <= 2)
            return 1;

        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (root >= list.get(i)) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }
        int totalSlots = (left.size() + right.size());
        int blankSpace = left.size();
        long nCr = pascalTable[totalSlots][blankSpace];
        long leftSide = dfs(left);
        long rightSide = dfs(right);

        long totalWays = (nCr * leftSide) % MOD;
        return (totalWays * rightSide) % MOD;
    }
}

