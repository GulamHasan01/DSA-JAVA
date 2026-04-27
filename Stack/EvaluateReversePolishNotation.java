package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] toc={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(toc));
    }

    public static int evalRPN(String[] tokens) {
        int a,ans=0;
        Stack<Integer> stack=new Stack<>();
        if (tokens.length==0) return 0;
        if (tokens[0].equals("*") || tokens[0].equals("/") || tokens[0].equals("-") || tokens[0].equals("+")) return 0;

        for (String token : tokens) {
            if (token.equals("+")) {
                if (stack.size()<2) return 0;
                a=stack.pop();
                ans=stack.pop()+a;
                stack.push(ans);
            } else  if (token.equals("/")) {
                if (stack.size()<2) return 0;
                a=stack.pop();
                ans=stack.pop()/a;
                stack.push(ans);
            } else  if (token.equals("*")) {
                if (stack.size()<2) return 0;
                a=stack.pop();
                ans=stack.pop()*a;
                stack.push(ans);
            } else if (token.equals("-")) {
                if (stack.size()<2) return 0;
                a=stack.pop();
                ans=stack.pop()-a;
                stack.push(ans);
            } else stack.push(Integer.parseInt(token));

        }
        return stack.peek();
    }
}
