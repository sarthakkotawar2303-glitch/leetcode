class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        Queue<Integer>q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        int completeTree=0;
        

        for(int i=0;i<n;i++){
            int nodesCount=0;
            int edgesCount=0;
           if(!visited[i]){
               visited[i]=true;
               q.offer(i);
               while(!q.isEmpty()){
                int node=q.poll();
                nodesCount++;
                edgesCount+=list.get(node).size();
                for (int v : list.get(node)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            q.offer(v);
                        }
                    }
               }
               if(edgesCount==nodesCount*(nodesCount-1)){
                completeTree++;
               }

           }
        }
return completeTree++;
    }
}