class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList());
        }

        for (int[] path : roads) {
            list.get(path[0]).add(new int[] { path[1], path[2] });
            list.get(path[1]).add(new int[] { path[0], path[2] });
        }

        Queue<Integer>q=new LinkedList<>();
        boolean[] visited=new boolean[n+1];
        int minDistance=Integer.MAX_VALUE;

        q.offer(1);
        visited[1]=true;

        while(!q.isEmpty()){
            int currentNode=q.poll();

            for(int[] nextOnes:list.get(currentNode)){
                int next=nextOnes[0];
                int distance=nextOnes[1];

                minDistance=Math.min(distance,minDistance);

                if(!visited[next]){
                    visited[next]=true;
                    q.offer(next);
                }
            }
        }
        return minDistance;
    }
}