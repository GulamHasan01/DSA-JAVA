package String;

import java.util.HashMap;
// Find the most frequent character in the string using HashMap
public class MostFreChar {
    public static void main(String[] args) {
        System.out.println(mostFre("asndfghadfa"));
    }

    public static char mostFre(String s){
        HashMap<Character,Integer>map=new HashMap<>();
        char[] ch =s.toCharArray();

        int max=0;
        char ans=' ';
        for (char c:ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int n:map.values()){
            max=Math.max(max,n);
        }
        for (char c:map.keySet()){
            if (map.get(c)==max){
               ans= c;
            }
        }
        return ans;
    }
}
