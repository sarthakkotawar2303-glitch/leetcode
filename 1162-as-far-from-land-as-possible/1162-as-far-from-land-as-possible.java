class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<int[]>q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1){
                q.offer(new int[]{i,j});
               }
            }
        }
        if(q.isEmpty() || q.size()==n*n) return -1;

        int maxDistance=-1;

        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int size=q.size();
            maxDistance++;

            for(int i=0;i<size;i++){
                int[] ar=q.poll();
                int row=ar[0];
                int col=ar[1];

                for(int[] a:directions){
                    int newRow=row+a[0];
                    int newCol=col+a[1];

                    if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==0){
                        grid[newRow][newCol]=1;
                        q.offer(new int[]{newRow,newCol});
                        
                    }
                }

            }
        }
        return maxDistance;
    }
}