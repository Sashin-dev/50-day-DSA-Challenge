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
       
        ListNode dummy = new ListNode(0);
        dummy.next= head;
        
        ListNode prev = dummy;
        while(prev.next!=null && prev.next.next!=null)
        {
            ListNode first = prev.next; //1->2->3->4
            ListNode second = prev.next.next; //2->3->4

            first.next = second.next;//1->3->4
            second.next = first; //2->1->3->4
            prev.next = second; //2->1->3->4

            prev = first; //1->3->4
        }

        return dummy.next;
        
    }
}