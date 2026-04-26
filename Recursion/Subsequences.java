package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsequences {
    public static void main(String[] args) {
      subsequence("","abc");
      removeLetter("","avcfr",'c');

    }

    public static void subsequence(String ans, String s){

        if (s.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch=s.charAt(0);

        subsequence(ans+ch,s.substring(1));
        subsequence(ans,s.substring(1));

    }

    public static void removeLetter(String ans, String s,char c){
        if (s.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch=s.charAt(0);
        if (ch==c){
            removeLetter(ans,s.substring(1),c);
        }else removeLetter(ans+ch,s.substring(1),c);


    }

}
