class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        boolean[] safe = new boolean[graph.length];
       

       for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfs(graph,i,visited,pathVisited,safe);
          
            }
       }

       List<Integer>ans=new ArrayList<>();

       for(int i=0;i<safe.length;i++){
               if(safe[i]){
                ans.add(i);
               }
        }
               return ans;
       }
       

    public boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] pathVisited, boolean[] safe) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int i : graph[node]) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, pathVisited, safe))
                    return true;
            } else if (pathVisited[i]) {
                return true;
            }
        }
        pathVisited[node] = false;
        safe[node] = true;

        return false;
    }
}