class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };
        
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        if (n == 1)
            return 1;

        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1;
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                int a = arr[0];
                int b = arr[1];

                for (int[] dir : directions) {
                    int r = a + dir[0];
                    int c = b + dir[1];

                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        q.offer(new int[] { r, c });
                        if (r == n - 1 && c == n - 1)
                            return level;
                    }
                }
            }
        }
        return -1;
    }
}