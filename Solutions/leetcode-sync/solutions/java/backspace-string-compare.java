class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='#' )
            {
                if( !stackS.isEmpty())
                    stackS.pop();
            }
            else
            {
                stackS.push(s.charAt(i));
            }
        }
        
        for(int i=0; i<t.length(); i++)
        {
            if(t.charAt(i)=='#')
            {
                if(!stackT.isEmpty())
                    stackT.pop();
            }
            else
            {
                stackT.push(t.charAt(i));
            }
        }
        
        // return s.equals(t);
        return isSameStack(stackS, stackT);
        
    }
    
    private boolean isSameStack(Stack<Character> stack1,
                            Stack<Character> stack2)
{
    // Create a flag variable
    boolean flag = true;
 
    // Check if size of both stacks are same
    if (stack1.size() != stack2.size())
    {
        flag = false;
        return flag;
    }
 
    // Until the stacks are not empty
    // compare top of both stacks
    while (stack1.empty() == false)
    {
        // If the top elements of both stacks
        // are same
        if (stack1.peek() == stack2.peek())
        {
            // Pop top of both stacks
            stack1.pop();
            stack2.pop();
        }
        else
        {
            // Otherwise, set flag to false
            flag = false;
            break;
        }
    }
 
    // Return flag
    return flag;
}
}