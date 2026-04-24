package Recursion;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(rev("abcdef",0,5));
        System.out.println(palindrome("abcba"));
    }
    public static String rev(String s,int f,int l) {
        char[] ch = s.toCharArray();
          helper(ch,f,l);
        return new String(ch);
    }
    public static void helper(char[] ch, int s, int e){
        if (s>=e){
            return;
        }
        char temp = ch[s];
        ch[s] = ch[e];
        ch[e] = temp;
        helper(ch,s+1,e-1);

    }
    public static boolean palindrome(String s){
        return s.equals(rev(s, 0, s.length() - 1));
    }
}
