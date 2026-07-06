package String;

import java.util.Stack;

public class reversestack {

    class Solution {
        public String reverse(String S) {
            // code here
            Stack<Character> stack=new Stack<>();

            for(int i=0;i<S.length();i++){
                stack.push(S.charAt(i));
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<stack.size();i++){
                sb.append(stack.pop());
            }

            return sb.toString();
        }
    }
}
