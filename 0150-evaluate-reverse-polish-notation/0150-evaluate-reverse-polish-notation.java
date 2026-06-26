class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i= 0 ;i<tokens.length;i++){
            if (!tokens[i].equals("+") &&
    !tokens[i].equals("-") &&
    !tokens[i].equals("*") &&
    !tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));

            }//operands
            else {
               int op2 = stack.pop();
                int op1 = stack.pop();

               int temp= 0;
               if(tokens[i].equals("+")){
                temp = op1 + op2;
               }
                 else if(tokens[i].equals("-")){
                temp = op1 - op2;
               }
                  else if(tokens[i].equals("*")){
                temp = op1 * op2;
               }
                  else if(tokens[i].equals("/")){
                temp = op1 / op2;
               }
               stack.push(temp);
            }
          
        }
          return stack.pop();

    }
}