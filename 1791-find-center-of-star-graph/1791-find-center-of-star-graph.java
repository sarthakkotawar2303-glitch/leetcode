class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer>set=new HashSet<>();
        for(int[] num:edges){
            if(set.contains(num[0])) return num[0];

            if(set.contains(num[1])) return num[1];

            set.add(num[0]);
            set.add(num[1]);
        }
        return -1;
    }
}