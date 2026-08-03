import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // Edge Case: If start or end cell is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        
        // Edge Case: Single element clear grid
        if (n == 1) {
            return 1;
        }

        // 8-directional shift array using proper integers
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1; // Mark as visited by mutating the grid
        
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            // Process all elements in the current BFS layer
            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                int a = arr[0];
                int b = arr[1];

                // If target reached at the beginning of processing, return level
                if (a == n - 1 && b == n - 1) {
                    return level;
                }

                for (int[] dir : directions) {
                    int r = a + dir[0];
                    int c = b + dir[1];

                    // Boundary checks and unvisited cell confirmation
                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
                        grid[r][c] = 1; // Mark visited immediately to prevent duplicates
                        q.offer(new int[] { r, c });
                    }
                }
            }
            level++; // Increment depth layer only after completing the current layer
        }
        return -1;
    }
}
