class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();

        int[] degree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList());
        }

        for(int[] pairs:prerequisites){
            int course=pairs[0];
            int pre=pairs[1];
            adj.get(pre).add(course);
            degree[course]++;
        }

        for(int i=0;i<numCourses;i++){
            if(degree[i]==0){
                q.offer(i);
            }
        }
        int idx=0;
        int[] order=new int[numCourses];

        while(!q.isEmpty()){
            int crs=q.poll();
            order[idx++]=crs;

            for(int nbr:adj.get(crs)){
                degree[nbr]--;
                if(degree[nbr]==0){
                   q.offer(nbr);
                }
            }
        }

        return idx!=numCourses?new int[0]:order;
        
    }
}