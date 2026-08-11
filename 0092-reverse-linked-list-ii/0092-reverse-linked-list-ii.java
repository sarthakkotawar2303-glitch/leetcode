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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
        return head;
    }

        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode beforeL=dummy;

        for(int i=1;i<left;i++){
                beforeL=beforeL.next;
        }
        ListNode tail=beforeL.next;
        ListNode prev=null;
        ListNode curr=beforeL.next;

        for(int i=1;i<=right-left+1;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        beforeL.next=prev;
        tail.next=curr;

        return dummy.next;
    }
}