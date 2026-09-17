class Solution {
    int timer = 0;
    int[] dt;
    int[] low;
    boolean[] visited;

    public void dfs(int node,int parent,List<List<Integer>>adj,List<List<Integer>>bridges){
            dt[node]=low[node]=timer++;
            visited[node]=true;

            for(int neighbour:adj.get(node)){
                if(!visited[neighbour]){
                    dfs(neighbour,node,adj,bridges);

                    low[node]=Math.min(low[node],low[neighbour]);

                    if(low[neighbour]>dt[node]) bridges.add(Arrays.asList(node,neighbour));
                }else if(neighbour!=parent){
                    low[node]=Math.min(dt[neighbour],low[node]);
                }
            }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList());

        for (List<Integer>arr : connections) {
            adj.get(arr.get(0)).add(arr.get(1));
            adj.get(arr.get(1)).add(arr.get(0));
        }

        List<List<Integer>> bridges = new ArrayList<>();
        dt = new int[n];
        low = new int[n];
        visited = new boolean[n];
        Arrays.fill(visited, false);

        //node parent bridges visited
        dfs(0, -1, adj, bridges);

        return bridges;

    }
}