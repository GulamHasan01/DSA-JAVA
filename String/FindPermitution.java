package String;

import java.util.Stack;


public class FindPermitution {
    public static void main(String[] args) {
        System.out.println(checkInclusion( "abc", "daabbaabbc"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        Stack<Character>stack=new Stack<>();
        if(s1.length()>s2.length()) return false;
        int[] fre=new int[26];
        int[] windowCount=new int[26];
        int windowSize = s1.length();

        for (char c:s1.toCharArray()) {
          fre[c-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
         windowCount[s2.charAt(i)-'a']++;

         if (i>=windowSize){
             windowCount[s2.charAt(i-windowSize)-'a']--;
         }
            if (matches(fre,windowCount)) {
                return true;
            }
        }
        return false;
    }
    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
