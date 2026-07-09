class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (token.equals("+")){
                int numb1 = stack.pop();
                int numb2 = stack.pop();
                stack.push(numb1 + numb2);
            } else if (token.equals("-")){
                int numb2 = stack.pop();
                int numb1 = stack.pop();
                stack.push(numb1 - numb2);
            } else if (token.equals("*")){
                int numb1 = stack.pop();
                int numb2 = stack.pop();
                stack.push(numb1 * numb2);
            } else if (token.equals("/")){
                int numb2 = stack.pop();
                int numb1 = stack.pop();
                stack.push(numb1 / numb2);
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
