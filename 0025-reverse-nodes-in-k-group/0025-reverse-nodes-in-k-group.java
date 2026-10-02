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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        ListNode l=head;
        ListNode r=head;

        while(r!=null){
            int i=0;
            while(i<k && r!=null){
                r=r.next;
                i++;
            }
            if(i<k) break;

            ListNode curr=l;
            ListNode prevNode=r;

            while(curr!=r){
                ListNode p=curr.next;
                curr.next=prevNode;
                prevNode=curr;
                curr=p;
            }
            prev.next=prevNode;
            prev=l;
            l=r;
        }
        return dummy.next;
    }
}