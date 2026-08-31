/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode curr=head.next;
        ListNode prev=head;
        ListNode n=curr.next;
        int maxRange=1_000_001;
        List<Integer>arr=new ArrayList<>();
        int i=1;
        int minDiff=maxRange;
        int maxDiff=0;
        int firstCP=0;
        int prevCP=0;
        



        while(curr!=null && curr.next!=null){
            int currValue=curr.val;
            int prevValue=prev.val;
            int nextValue=n.val;

            //condition for maxima cp
            if(currValue>prevValue && currValue>nextValue || currValue<prevValue && currValue<nextValue){
                 if(prevCP==0){
                    firstCP=i;
                    prevCP=i;
                 }else{
                    minDiff=Math.min(minDiff,i-prevCP);
                    prevCP=i;
                 }
            }
           
            prev=curr;
            curr=n;
            n=n.next;
            i++;
        }
        if(minDiff!=maxRange){
            maxDiff=prevCP-firstCP;
            return new int[]{minDiff,maxDiff};
        }

        return new int[]{-1,-1};
        
    }
}