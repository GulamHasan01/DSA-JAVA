package String;

import java.util.Arrays;

public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(isValid("abca"));
    }
    public static boolean isValid(String s){
        int i=0;
        int j=s.length()-1;


        while (i<j) {
            if (s.charAt(i)!=s.charAt(j)){
               return ispallindrome(s,i+1,j) || ispallindrome(s,i,j+1);
            }
            i++;
            j--;
        }
         return true;
    }
    public static boolean ispallindrome(String s,int left,int right){
        while (left<right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else return false;

        }
        return true;
    }
}
