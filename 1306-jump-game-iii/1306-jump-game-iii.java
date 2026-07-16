class Solution {
    public boolean canReach(int[] arr, int start) {
        
        Set<Integer>set=new HashSet<>();
        Queue<Integer>q=new LinkedList<>();

        int size=arr.length-1;

        set.add(start);
        q.offer(start);

        while(!q.isEmpty()){

            int num=q.poll();
            if(arr[num]==0) return true;
            

            if(arr[num]+num<=size && !set.contains(arr[num]+num)){
                q.offer(arr[num]+num);
                set.add(arr[num]+num);
            }

            if(num-arr[num]>=0 && !set.contains(num-arr[num])){
                q.offer(num-arr[num]);
                set.add(num-arr[num]);
            }

        }
        return false;
    }
}