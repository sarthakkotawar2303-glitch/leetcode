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
    public ListNode swapPairs(ListNode head) {

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;

        while(curr!=null && curr.next!=null){
            ListNode fst=curr;
            ListNode snd=curr.next;

            fst.next=snd.next;
            snd.next=fst;
            prev.next=snd;

            prev=fst;
            curr=fst.next;
        }

        return dummy.next;
        
    }
}