package String;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveSpace {
    public static void main(String[] args) {
        System.out.println((removeSpace("abc defa sdfs g")));
    }

    private static String removeSpace(String s) {
        char[] ch=s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char chh:ch) {
            if (chh==' '){
                continue;
            }else{
                ans.append(chh);
            }
        }

        return ans.toString();
    }

    public static void palindrome(String s){
        char[] ch=s.toCharArray();
        StringBuilder helper = new StringBuilder();
        for (char chh:ch) {
            if (chh==' '){
                continue;
            }else{
                helper.append(chh);
            }
        }
//        int f=0;
//        int l=s.length()-1;
//        while (f<l){
//            char temp = ch[f];
//            ch[f] = ch[l];
//            ch[l] = temp;
//            f++;
//            l--;
//        }
        StringBuilder rev= helper.reverse();
        helper.toString().toLowerCase();
        rev.toString().toLowerCase();
        if (rev.toString().equals(helper.toString())){
            System.out.println("palindrome");
        }else System.out.println("not a pallindrome");
    }
}
