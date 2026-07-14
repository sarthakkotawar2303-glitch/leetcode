import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Initialize adjacency lists using array of lists
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }

        // Build both graphs correctly
        for (int[] edge : redEdges) redGraph[edge[0]].add(edge[1]);
        for (int[] edge : blueEdges) blueGraph[edge[0]].add(edge[1]);

        // Initialize result array with -1
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Queue stores: [node, incoming_color] (0 = Red, 1 = Blue)
        Queue<int[]> queue = new LinkedList<>();
        
        // 2D visited array: visited[node][color]
        boolean[][] visited = new boolean[n][2];

        // Start from node 0 with both color possibilities
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        visited[0][0] = true;
        visited[0][1] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int node = current[0];
                int color = current[1];

                // Record distance if visiting for the first time
                if (result[node] == -1) {
                    result[node] = steps;
                }

                // If last edge was red (0), next must be blue (1)
                if (color == 0) {
                    for (int neighbor : blueGraph[node]) {
                        if (!visited[neighbor][1]) {
                            visited[neighbor][1] = true;
                            queue.offer(new int[]{neighbor, 1});
                        }
                    }
                } 
                // If last edge was blue (1), next must be red (0)
                else {
                    for (int neighbor : redGraph[node]) {
                        if (!visited[neighbor][0]) {
                            visited[neighbor][0] = true;
                            queue.offer(new int[]{neighbor, 0});
                        }
                    }
                }
            }
            steps++;
        }

        return result;
    }
}
