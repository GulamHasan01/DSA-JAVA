package String;

import java.util.HashMap;





//           not solve






public class LongestHappyPrefix {
    public static void main(String[] args) {
        System.out.println(longestPrefix("ababab"));
    }

    public static String longestPrefix(String s) {
        HashMap<String,Integer>map=new HashMap<>();
        String ans="";
        int ansSize=0;
        int count=0;
        StringBuilder sb=new StringBuilder();
        StringBuilder sf=new StringBuilder();

        for (int i = 0; i < s.length()-1; i++) {
           map.put(sb.append(s.charAt(i)).toString(),map.get(sb.length()));
        }
        System.out.println(map);
        for (int i = s.length()-1; i >0 ; i--) {
            if (map.containsKey(sf.append(s.charAt(i)).reverse().toString())){
                if (ansSize<sf.length()){
                    ans=sf.toString();
                }
                count++;
            }
        }
     return count==0?"":ans;
    }
}
