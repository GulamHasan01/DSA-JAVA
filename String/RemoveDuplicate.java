package String;


import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        System.out.println((removeDup("abcdefasdfsg")));
    }

    private static String removeDup(String s) {
        char[] ch=s.toCharArray();

        Set<Character> set= new LinkedHashSet<>();
        for (char chh:ch) {
            set.add(chh);
        }
        StringBuilder ans= new StringBuilder();
        for (char c:set){
            ans.append(c);
        }
        return ans.toString();
    }


}
