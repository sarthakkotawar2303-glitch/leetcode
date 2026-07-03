class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int max=n*n;
        boolean[] visited=new boolean[(n*n)+1];

        Queue<Integer>q=new LinkedList<>();
        q.offer(1);
        int level=0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                if(curr==max) return level;

                for(int next=curr+1;next<=Math.min(max,curr+6);next++){
                    int dest=next;

                    // if(visited[dest]) continue;

                    //calculating row and col
                    int row=(dest-1)/n;
                    int col=(dest-1)%n;

                    if(row%2==1){
                        col=n-col-1;
                    }
                    //calaculating row from the bootom as it is grid
                    row=n-row-1;

                    if(board[row][col]!=-1){
                          dest=board[row][col];
                    }

                    if(!visited[dest]){
                        visited[dest]=true;
                        q.offer(dest);
                    }

                }
            }
            level++;
        }
        return -1;
    }
}