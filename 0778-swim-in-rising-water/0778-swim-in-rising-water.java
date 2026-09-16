class Solution {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        //row col T
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        dist[0][0] = grid[0][0];
        pq.offer(new int[] { 0, 0, grid[0][0] });

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int row = arr[0];
            int col = arr[1];
            int d = arr[2];
            if (d > dist[row][col])
                continue;
            if (row == n - 1 && col == n - 1)
                return d;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    int maxD = Math.max(d, grid[newRow][newCol]);
                    if (maxD < dist[newRow][newCol]) {
                        dist[newRow][newCol] = maxD;
                        pq.offer(new int[] { newRow, newCol, maxD });
                    }
                }
            }
        }
        return -1;
    }
}