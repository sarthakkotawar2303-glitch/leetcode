class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      boolean[] visited=new boolean[rooms.size()+1];  
      Queue<Integer>q=new LinkedList<>();
      visited[0]=true;
      q.offer(0);

      while(!q.isEmpty()){
        int node=q.poll();
        for(int m:rooms.get(node)){
            if(!visited[m]){
                visited[m]=true;
                q.offer(m);
            }
        }
      } 
      for(int i=1;i<rooms.size();i++){
        if(!visited[i]) return false;
      }

      return true;
    }
}