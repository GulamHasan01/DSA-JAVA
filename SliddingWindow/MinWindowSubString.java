package SliddingWindow;

import java.util.HashMap;

public class MinWindowSubString {

    public String minWindow(String s, String t) {
        if (t.length()>s.length()) return "";

        HashMap<Character,Integer>window=new HashMap<>();
        HashMap<Character,Integer>need=new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        int minlen=Integer.MAX_VALUE;
        int have=0;
        int left=0;
        int start=0;
        int require=need.size();

        for (int i = 0; i < s.length(); i++) {
         char ch=s.charAt(i);
         window.put(ch,window.getOrDefault(ch,0)+1);
         if (need.containsKey(ch) && window.get(ch).intValue()==need.get(ch).intValue()){
             have++;
         }
         while (have==require){
             if (i - left + 1 < minlen) {
                 minlen = i - left + 1;
                 start = left;
             }

         char leftchar=s.charAt(left);
         window.put(leftchar,window.get(leftchar)-1);

         if (need.containsKey(leftchar) && window.get(leftchar)<need.get(leftchar)){
             have--;
         }
         left++;
         }
        }
        return (minlen==Integer.MAX_VALUE)?"":s.substring(start,start+minlen);
    }
}
