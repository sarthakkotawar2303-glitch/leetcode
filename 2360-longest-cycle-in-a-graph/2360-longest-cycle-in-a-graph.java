class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visitedAt = new int[n]; // Tracks the step/distance when a node was visited in the current run
        boolean[] visited = new boolean[n]; // Tracks globally visited nodes
        int maxLen = -1;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int curr = i;
            int dist = 1; // Start distance tracking from 1

            while (curr != -1 && !visited[curr]) {
                visited[curr] = true;
                visitedAt[curr] = dist;

                int nextNode = edges[curr];

                // If nextNode was visited in the current DFS path
                if (nextNode != -1 && visited[nextNode] && visitedAt[nextNode] > 0) {
                    int cycleLen = dist - visitedAt[nextNode] + 1;
                    maxLen = Math.max(maxLen, cycleLen);
                    break;
                }

                curr = nextNode;
                dist++;
            }

            // Clean up visitedAt tracking for the next independent DFS run
            curr = i;
            while (curr != -1 && visitedAt[curr] > 0) {
                visitedAt[curr] = 0;
                curr = edges[curr];
            }
        }

        return maxLen;
    }
}
