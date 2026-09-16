class disJoinSet {
    int[] parent;
    int[] sizeOfParent;

    disJoinSet(int n) {
        parent = new int[n];
        sizeOfParent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sizeOfParent[i] = 1;
        }
    }

    public void UnionBySize(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA == parentB)
            return;

        if (sizeOfParent[parentA] < sizeOfParent[parentB]) {
            parent[parentA] = parentB;
            sizeOfParent[parentB] += sizeOfParent[parentA];
        } else {
            parent[parentB] = parentA;
            sizeOfParent[parentA] += sizeOfParent[parentB];
        }

    }

    public int findParent(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = findParent(parent[a]);
    }
}

class Solution {

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        disJoinSet ds = new disJoinSet(n * n);

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    if ((newRow >= 0 && newRow < n && newCol >= 0 && newCol < n)
                            && grid[newRow][newCol] == 1) {
                        int node = i * n + j;
                        int adjNode = newRow * n + newCol;

                        ds.UnionBySize(node, adjNode);
                    }
                }
            }
        }

        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                HashSet<Integer> set = new HashSet<>();
                if (grid[i][j] == 1)
                    continue;
                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    if ((newRow >= 0 && newRow < n && newCol >= 0 && newCol < n)
                            && grid[newRow][newCol] == 1) {
                        set.add(ds.findParent(newRow * n + newCol));
                    }

                }

                int size = 1;
                for (int s : set) {
                    size += ds.sizeOfParent[s];
                }

                maxSize = Math.max(maxSize, size);

            }
        }

        for (int p = 0; p < n * n; p++) {
            maxSize = Math.max(maxSize, ds.sizeOfParent[p]);
        }

        return maxSize;

    }
}