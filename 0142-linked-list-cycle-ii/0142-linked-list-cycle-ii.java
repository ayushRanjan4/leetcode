/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode temp1=head;
        ListNode temp2=head;
        while(temp2!=null &&temp2.next!=null){
            
            temp2=temp2.next.next;
            temp1=temp1.next;
            if(temp2==temp1) break;
        }
        if (temp2 == null || temp2.next == null) return null;
        while (head != temp1) {
            head = head.next;
            temp1 = temp1.next;
        }
        return head;

    }
}