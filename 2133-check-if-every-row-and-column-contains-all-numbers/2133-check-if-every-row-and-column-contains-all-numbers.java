class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        HashSet<Integer>[]rows=new HashSet[n];
        HashSet<Integer>[]cols=new HashSet[n];

        for(int i=0;i<n;i++){
              rows[i]=new HashSet();
              cols[i]=new HashSet();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int cr=matrix[i][j];

                if(rows[i].contains(cr) || cols[j].contains(cr)) return false;

                rows[i].add(cr);
                cols[j].add(cr);
            }
        }
        return true;
        
    }
}