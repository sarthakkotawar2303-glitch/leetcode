class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]>q=new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }

        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] n=q.poll();
            int r=n[0];
            int c=n[1];

            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length && mat[nr][nc]==-1){
                    mat[nr][nc]=mat[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}