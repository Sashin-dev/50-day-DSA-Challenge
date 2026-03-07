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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        // ListNode finalN = new ListNode();
        
        Set<Integer> set = new TreeSet<>();
        while(curr!=null)
        {
            set.add(curr.val);
            curr= curr.next;
        }
        
        Iterator<Integer> values = set.iterator();
        ListNode finalN = new ListNode();
        ListNode temp = finalN;
        while(values.hasNext())
        {
            ListNode temp2 = new ListNode(values.next());
            temp.next = temp2;
            temp = temp.next;
        }
        
        return finalN.next;
    }
}