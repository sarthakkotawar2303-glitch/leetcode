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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode last=head;
        int len=1;

        while(last.next!=null){
            last=last.next;
            len++;
        }
        last.next=head;
        k=k% len;

        int steps=(len-k-1);
        
        while(steps>0){
            head=head.next;
            steps--;
        }
        ListNode newHead=head.next;
        head.next=null;

        return newHead;
    }
}