class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        while(n>0){
            pq.offer(n%10);
            n=n/10;
        }

        int num=pq.poll();
        return num*pq.poll();

    }
}