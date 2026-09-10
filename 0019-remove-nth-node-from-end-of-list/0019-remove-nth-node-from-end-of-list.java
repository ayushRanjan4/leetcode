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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        int num=1;
        int len=length(head);
        int count=len-n+1;
        ListNode temp= head;
        if(len==1&&n==1)return null;
        if(len==n)return head.next;
        while(temp!=null&&temp.next!=null){
            if(num==count-1){
                temp.next=temp.next.next;
                // break;
            }
            temp=temp.next;
            num++;

        }
        return head;
        
    }
    public int length(ListNode head){
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return len;
    }
}