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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode();

        ListNode pt=dummy;
        while(list1!=null && list2!=null){
           if(list1.val<=list2.val){
               pt.next=new ListNode(list1.val);
               pt=pt.next;
               list1=list1.next;
           }else{
              pt.next=new ListNode(list2.val);
              pt=pt.next;
              list2=list2.next;
           }
        }
        pt.next=(list1!=null)?list1:list2;;

        return dummy.next;
    }
}