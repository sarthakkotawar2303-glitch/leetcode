class djs {
    int[] parent;
    int[] size;
    int NoOfComponents = 0;

    djs(int n){
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

    public boolean union(int a,int b){
        int parentA=find(a);
        int parentB=find(b);
        NoOfComponents++;

        if(parentA==parentB) return true;

        if(size[parentA]<=size[parentB]){
            parent[parentA]=parentB;
            size[parentB]+=size[parentA];
        }else{
            parent[parentB]=parentA;
            size[parentA]+=size[parentB];
        }

        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        djs d=new djs(n+1);
        for(int[]arr:edges){
            int a=arr[0];
            int b=arr[1];

            if(d.union(a,b)){
                return arr;
            }
        }
        return new int[]{};
    }
}