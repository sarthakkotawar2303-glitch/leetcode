class disjointSet{ 
    int[] parent;
    int[] unionBySize;
    int n;
   

    disjointSet(int n){
        this.n=n;
       parent=new int[n];
       unionBySize=new int[n];
       

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
    public int removeStones(int[][] stones) {

        int maxRow=0;
        int maxCol=0;

        for(int[] arr:stones){
            maxRow=Math.max(maxRow,arr[0]);
            maxCol=Math.max(maxCol,arr[1]);
        }

        disjointSet ds=new disjointSet(maxRow+maxCol+1+1);
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int arr[]:stones){
            int nodeRow=arr[0];
            int nodeCol=arr[1]+maxRow+1;

            ds.Union(nodeRow,nodeCol);
            map.put(nodeRow,1);
            map.put(nodeCol,1);
        }

        int comp=0;

        for(int key:map.keySet()){
            if(ds.findParent(key)==key) comp++;
        }

        return stones.length-comp;
       
        
    }
}