package String;

import java.util.Stack;

public class RemoveAllOccOFSubStr {

    public static void main(String[] args) {
        System.out.println(removeOccurrences( "daabcbaabcbc", "abc"));
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder ans=new StringBuilder();
       char[] ch=s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            ans.append(ch[i]);
            if (ans.length()>=part.length()) {
                if (ans.substring(ans.length() - part.length(), ans.length()).equals(part)) {
                    ans.delete(ans.length() - part.length(), ans.length());
                }
            }
        }
        return ans.toString();
    }
}
