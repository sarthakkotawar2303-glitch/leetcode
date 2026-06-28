class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
       boolean[] visited =new boolean[n+1];
       Queue<Integer>q=new LinkedList<>();
       int provinces=0;

       for(int i=0;i<n;i++){
        if(!visited[i]){
            visited[i]=true;
            q.offer(i);
            provinces++;

            while(!q.isEmpty()){
                 int node=q.poll();
                  for(int j=0;j<isConnected[0].length;j++){
                 if(isConnected[node][j]==1 && !visited[j]){
                    visited[j]=true;
                    q.offer(j);
                 }
            }
            }
        }

       }
       return provinces;
    }
}