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
        ListNode preRev = null;
        ListNode curr = head;
        
        int iter=1;
        while(iter<left){
            iter++;
            preRev=curr;
            curr=curr.next;
        }
        
        ListNode end =curr;
        ListNode prev = null;
        
        while(iter<=right)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev =curr;
            curr = temp;
            iter++;
        }
        
        end.next = curr;
        if(preRev!=null ) preRev.next = prev;
        return preRev==null ?  prev : head;
        
        
        
    }
}