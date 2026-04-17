package String;

import java.util.HashMap;

// Sliding window with two HashMaps to find minimum substring containing all characters of target

public class MinWindowSubStr {
    public static void main(String[] args) {
        System.out.println(minWinSubStr("abakcljsdfhcba","abc"));
    }

    public static String minWinSubStr(String s,String w){
        HashMap<Character,Integer>window=new HashMap<>();
        HashMap<Character,Integer>need=new HashMap<>();
        int minlen=Integer.MAX_VALUE;
        int left=0,start=0;
        for (int i = 0; i < w.length(); i++) {
            need.put(w.charAt(i),need.getOrDefault(w.charAt(i),0)+1);
        }
        int have=0;
        int require=need.size();

        for (int right=0;right<s.length();right++){
             window.put(s.charAt(right),window.getOrDefault(s.charAt(right),0)+1);
             if (need.containsKey(s.charAt(right)) &&
                     window.get(s.charAt(right)).intValue()==need.get(s.charAt(right)).intValue()){
                  have++;
             }
             while (have==require) {
                 if (right - left + 1 < minlen) {
                     minlen = right - left + 1;
                     start = left;
                 }
                 char leftChar=s.charAt(left);
                 window.put(leftChar,window.get(leftChar)-1);
                 if (need.containsKey(leftChar) && need.get(leftChar)> window.get(leftChar)){
                     have--;
                 }
                 left++;
             }

        }
        return minlen==Integer.MAX_VALUE?"" :s.substring(start,start+minlen);
    }
}
