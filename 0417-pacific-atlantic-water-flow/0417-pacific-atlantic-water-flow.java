class Solution {

    int[][] directions={{1,0},{-1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n=heights.length;
        int m=heights[0].length;

        boolean[][] pacific=new boolean[n][m];
        boolean[][] atlantic=new boolean[n][m];

        //from pacific
        //traveling top row
        for(int i=0;i<m;i++){
            dfs(0,i,heights,pacific);
        }

        //trveling left side col
        for(int i=0;i<n;i++){
            dfs(i,0,heights,pacific);
        }

        //Atlantic
        //traveling bottom row
        for(int i=0;i<m;i++){
            dfs(n-1,i,heights,atlantic);
        }
        //traveling right col
        for(int i=0;i<n;i++){
            dfs(i,m-1,heights,atlantic);
        }

        List<List<Integer>>ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                   ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
         
    }

    public void dfs(int r,int c,int[][]heights,boolean[][] visited){

        if(visited[r][c]) return;

        visited[r][c]=true;

        for(int[] dir:directions){
            int nr=dir[0]+r;
            int nc=dir[1]+c;

            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && !visited[nr][nc] && heights[r][c]<=heights[nr][nc]){
                dfs(nr,nc,heights,visited);
            }
            
        }
    }
}