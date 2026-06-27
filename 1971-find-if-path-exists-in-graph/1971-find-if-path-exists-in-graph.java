class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1)
            return true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(v).add(u);
            adj.get(u).add(v);

        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        boolean[] visited = new boolean[n + 1];
        visited[source] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int a : adj.get(node)) {
                if (a == destination)
                    return true;
                    if(!visited[a]){
                        visited[a]=true;
                        q.offer(a);
                    }
                    
            }
        }
        return false;
    }
}