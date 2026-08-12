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
    public void reorderList(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //Reverse the second half
        ListNode prev=null;
        ListNode curr=slow.next;
        
        //remove the second half from first half
        slow.next=null;

        while(curr!=null){
            ListNode currN=curr.next;

            curr.next=prev;
            prev=curr;
            curr=currN;
        }

        ListNode start=head;

        //Now first Half Starts -> start
        // second half starts -> prev

        //loop will run untill second half is not over
        while(prev!=null){
            ListNode fstN=start.next;
            ListNode sndN=prev.next;

            start.next=prev;
            prev.next=fstN;

            start=fstN;
            prev=sndN;
        }

    }
}