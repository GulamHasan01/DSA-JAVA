package String;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(rev("abcdef",0,5));
    }
    public static String rev(String s,int f,int l){
        char[] ch= s.toCharArray();



        while (f<l) {

            char temp = ch[f];
            ch[f] = ch[l];
            ch[l] = temp;
            f++;
            l--;
        }
      String ans=new String(ch);
       return ans;
    }
}
