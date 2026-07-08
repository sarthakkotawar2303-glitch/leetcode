class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] result=new int[n];
        x--;
        y--;

        int steps=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int normlPath=Math.abs(i-j);

                int shortesPath_1=Math.abs(i-x)+1+Math.abs(j-y);

                int shortestPath_2=Math.abs(i-y)+1+Math.abs(j-x);

                int shortestPath=Math.min(normlPath,Math.min(shortesPath_1,shortestPath_2));

                result[shortestPath-1]+=2;
            }
        }
        return result;
        
    }
}