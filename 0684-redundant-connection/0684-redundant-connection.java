class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int[] edg : edges) {
            int rootU, rootV;

            // Calls find() inside the condition and saves the roots on the fly
            if ((rootU = find(edg[0], parents)) == (rootV = find(edg[1], parents))) {
                return edg; // Cycle detected, return the edge directly!
            }

            // Correctly connects the absolute roots
            parents[rootU] = rootV;
        }
        return new int[]{};
    }

    public int find(int node, int[] parents) {
        if (parents[node] != node) {
            parents[node] = find(parents[node], parents); // Path compression
        }
        return parents[node];
    }
}
