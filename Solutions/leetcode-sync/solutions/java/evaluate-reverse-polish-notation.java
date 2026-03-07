class Solution {
    public int evalRPN(String[] tokens) {
     Stack<Integer> numStack = new Stack<>();
        Set<String> operands = Set.of("+", "-", "/", "*");
        for (int i=0; i< tokens.length; i++)
        {
            if(operands.contains(tokens[i])){
                int op1 = numStack.pop();
                int op2 = numStack.pop();
                switch (tokens[i]) {
                    case "+":
                      numStack.push(op1+op2);
                      break;

                    case "-":
                        numStack.push(op2-op1);
                        break;
                    case "*":
                        numStack.push(op1*op2);
                        break;
                    case "/":
                        numStack.push(op2/op1);
                        break;
                }
            }
            else {
                numStack.push(Integer.parseInt(tokens[i]));
            }
        }
        return numStack.pop();

    }
}