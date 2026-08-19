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

    public ListNode mergList(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode();
        ListNode pt=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
               pt.next=new ListNode(l1.val);
               pt=pt.next;
               l1=l1.next;
             }else if(l1.val>l2.val){
                pt.next=new ListNode(l2.val);
                pt=pt.next;
                l2=l2.next;
             }
        }
        pt.next=(l1!=null)?l1:l2;

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head=new ListNode();
        ListNode pt=head;
        for(int i=0;i<lists.length;i++){
           pt.next=mergList(pt.next,lists[i]);
        }
        return head.next;
    }
}