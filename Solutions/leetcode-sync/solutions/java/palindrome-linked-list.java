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
    public boolean isPalindrome(ListNode head) {
        Integer len = findLen(head);
        ListNode temp = head;
        if(head==null || head.next==null)
        {
            return true;
        }
        int i=0;
        Stack<Integer> stack = new Stack<>();
        // System.out.println("length: " +len) ;
        
        
        while(i< len/2)
        {
            stack.push(temp.val);
            temp = temp.next;
            
            i++;
            // System.out.println("i : " + i);
        }
        // System.out.println("queue :" + stack);
        if(len%2!=0)
        {
           temp = temp.next;
        }
        while(temp!=null )
        {
            // if(!stack.isEmpty())
            // {
                // System.out.println(stack.peek());
            // }
            if(stack.isEmpty() || stack.pop()!=temp.val)
            {
                return false;
            }
            temp = temp.next;
        }
         //queue.size()>0 ? return false : return true;
        return true;
    }
    
    private Integer findLen(ListNode head)
    {
        ListNode temp = head;
        int len=1;
        while(temp.next!=null)
        {
            temp = temp.next;
            len++;
        }
        return len;
    }
}