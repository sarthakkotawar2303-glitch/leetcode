class dsj {
    int[] parent;
    int[] size;
    int NoOfComponents = 0;

    dsj(int n){
        parent=new int[n];
        size=new int[n];

        for(int i=1;i<n;i++){
           parent[i]=i;
           size[i]=1;
        }
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }

    public void union(int a,int b){
        int parentA=find(a);
        int parentB=find(b);
        

        if(parentA==parentB) return;
        NoOfComponents++;

        if(size[parentA]<=size[parentB]){
            parent[parentA]=parentB;
            size[parentB]+=size[parentA];
        }else{
            parent[parentB]=parentA;
            size[parentA]+=size[parentB];
        }

        return;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        dsj d=new dsj(n+1);

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    d.union(i,j); 
                }
            }
        }

        return n-d.NoOfComponents;

    }
}