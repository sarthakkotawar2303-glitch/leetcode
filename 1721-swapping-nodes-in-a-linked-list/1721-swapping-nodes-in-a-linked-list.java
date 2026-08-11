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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode fast=head;
        ListNode slow=head;

        for(int i=1;i<k;i++){
              fast=fast.next;
        }
        ListNode firstK=fast;

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        int temp=slow.val;
        slow.val=firstK.val;
        firstK.val=temp;

        return head;
    }
}