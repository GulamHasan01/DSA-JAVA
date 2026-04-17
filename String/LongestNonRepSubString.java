package String;

import java.util.HashSet;

// Sliding window with HashSet to maintain unique characters and find longest substring

public class LongestNonRepSubString {
    public static void main(String[] args) {
        System.out.println(lonNonRepSubStr("abba"));
    }

    public static String lonNonRepSubStr(String s){
        HashSet<Character>set=new HashSet<>();
        int maxlen=0;
        int left=0,start=0;
        for (char right=0;right<s.length();right++){
           while (set.contains(s.charAt(right))){
               set.remove(s.charAt(left));
               left++;
           }
           set.add(s.charAt(right));

           if (right-left+1>maxlen){
               maxlen=right-left+1;
               start=left;
           }
        }
        return s.substring(start,start+maxlen);
    }
}
