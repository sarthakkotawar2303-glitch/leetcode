class disjointSet{ 
    int[] parent;
    int[] unionBySize;
    int n;

    disjointSet(int n){
       parent=new int[n];
       unionBySize=new int[n];
       this.n=n;

       for(int i=0;i<n;i++){
         parent[i]=i;
         unionBySize[i]=1;
       }
    }

    public void Union(int a,int b){
        int pa=findParent( a);
        int pb=findParent( b);

        if(pa==pb) return;

        if(unionBySize[pa]>=unionBySize[pb]){
            parent[pb]=pa;
            unionBySize[pa]+=unionBySize[pb];
        }else{
            parent[pa]=pb;
            unionBySize[pb]+=unionBySize[pa];
        }
    }

    public int findParent(int a){
        if(parent[a]==a) return a;
        return parent[a]=findParent(parent[a]);
    }

    public int getNoOfCompnents(){
        int comp=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) comp++;
        }
        return comp;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extEdgs=0;
        disjointSet ds=new disjointSet(n);
        for(int[] info:connections){
            int a=info[0];
            int b=info[1];

            if(ds.findParent(a)==ds.findParent(b)) extEdgs++;

            else{
                ds.Union(a,b);
            }
        }

        int totalComp=ds.getNoOfCompnents();
        int minRequiredEdges=totalComp-1;

        if(extEdgs>=minRequiredEdges) return minRequiredEdges;

        return -1;


    }
}