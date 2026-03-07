class MinStack {
    Stack<Integer> trackStack = null;
    Stack<Integer> mainStack = null;
    public MinStack() {
         trackStack = new Stack<Integer> ();
          mainStack = new Stack<Integer> ();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(mainStack.size()==1)
        {
            trackStack.push(val);
        }

        if(val < trackStack.peek())
        {
            trackStack.push(val);
        }else
        {
            trackStack.push(trackStack.peek());
        }
        
    }
    
    public void pop() {
        trackStack.pop();
        mainStack.pop();
    }
    
    public int top() {
       return mainStack.peek();
    }
    
    public int getMin() {
        return trackStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */