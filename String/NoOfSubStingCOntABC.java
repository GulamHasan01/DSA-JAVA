package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NoOfSubStingCOntABC {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }
    public static int numberOfSubstrings(String s) {
       char[] cCount=new char[3];

    int left=0;
    int count=0;
    for (int i = 0; i <s.length() ; i++) {
       cCount[s.charAt(i)-'a']++;
       while (cCount[0]>0 && cCount[1]>0 && cCount[2]>0){
           count+=s.length()-i;
           cCount[s.charAt(left)-'a']--;
           left++;
       }
        }
        return count;
    }
}
