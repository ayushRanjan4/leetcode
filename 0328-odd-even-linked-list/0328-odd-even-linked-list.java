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
    public ListNode oddEvenList(ListNode head) {
        // ListNode ans = new ListNode(-1);
        // ListNode dummy = ans;
        if (head == null || head.next == null) return head;
        // ListNode temp = head;
        // while (temp != null) {
        //     ListNode n = new ListNode(temp.val);
        //     dummy.next = n;
        //     dummy = dummy.next;
        //     if (temp.next == null) break;
        //     temp = temp.next.next;
        // }
        // ListNode temp1 = head.next;
        // while (temp1 != null) {
        //     ListNode n = new ListNode(temp1.val);
        //     dummy.next = n;
        //     dummy = dummy.next;
        //     if (temp1.next == null) break;
        //     temp1 = temp1.next.next;
        // }
        ListNode odd=new ListNode(-1);
        ListNode even=new ListNode(-1);

        ListNode o=odd;
        ListNode e=even;
        boolean flag=false;
        ListNode temp=head;
        while(temp!=null){
            if(!flag){
                ListNode prev=temp.next;
                o.next=temp;
                temp.next=null;
                o=o.next;
                temp=prev;
                flag=true;
            }
            else if(flag){
                ListNode prev=temp.next;
                e.next=temp;
                temp.next=null;
                e=e.next;
                temp=prev;
                flag=false;
            }
        }
        o.next=even.next;
        return odd.next;
    }
}