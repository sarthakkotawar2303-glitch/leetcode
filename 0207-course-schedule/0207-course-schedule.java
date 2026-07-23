import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] preC = new int[numCourses];

        for(int[] num : prerequisites){
            int u = num[0]; // course 
            int v = num[1]; // prerequisite

            adj.get(v).add(u);
            preC[u]++; 
        }

        
        for(int i = 0; i < numCourses; i++){
            if(preC[i] == 0){
               q.offer(i);
            }
        }
        
        int visit = 0;
        
        while(!q.isEmpty()){
             int current = q.poll();
             visit++;

             for(int n : adj.get(current)){
                preC[n]--;

                if(preC[n] == 0) {
                    q.offer(n);
                }
             }
        }

        return visit == numCourses;
    }
}
