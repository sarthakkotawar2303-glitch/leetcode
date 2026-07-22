class Solution {
    public int orangesRotting(int[][] grid) {
        int freshT=0;
        Queue<int[]>q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshT++;
                }
            }
        }

        if(freshT==0) return 0;

        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        int min=0;

        while(!q.isEmpty() && freshT>0){
            min++;
            int size=q.size();
            for(int i=0;i<size;i++){
                  int[] num=q.poll();
              int r=num[0];
              int c=num[1];

              for(int[] dir:directions){
                  int nrow=r+dir[0];
                  int ncol=c+dir[1];

                  if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                    q.offer(new int[]{nrow,ncol});
                    grid[nrow][ncol]=2;
                    freshT--;
                  }
                }
            }
            }
            return freshT==0?min:-1; 
        }
}