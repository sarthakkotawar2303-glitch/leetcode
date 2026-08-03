class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]>q=new LinkedList<>();
        int level=0;
        int n=maze.length;
        int m=maze[0].length;
        int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
        maze[entrance[0]][entrance[1]]='+';
        q.offer(entrance);

        while(!q.isEmpty()){
            int size=q.size();
            level++;
            for(int i=0;i<size;i++){
                int[] arr=q.poll();
                int a=arr[0];
                int b=arr[1];
                

                for(int[] dir:directions){
                    int r=dir[0]+a;
                    int c=dir[1]+b;

                    if(r>=0 && r<n && c>=0 && c<m && maze[r][c]=='.'){
                        maze[r][c]='+';
                        q.offer(new int[]{r,c});
                        q.offer(new int[]{r,c});
                        if(r==n-1 || r==0 || c==0 || c==m-1) return level;
                    }
                }
            }
        }
        return -1;

    }
}