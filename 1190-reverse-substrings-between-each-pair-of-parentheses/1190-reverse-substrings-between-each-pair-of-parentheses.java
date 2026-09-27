import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        int i = 0;

        Stack<Character> stack = new Stack<>();

        while (i < s.length()) {
            if (s.charAt(i) != ')') {
                stack.push(s.charAt(i));

            } else {

                StringBuilder sb = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }

                for (int j = 0; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            }
            i++;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
