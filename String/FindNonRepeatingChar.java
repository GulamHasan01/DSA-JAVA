package String;

import java.util.HashMap;
import java.util.Map;
// Find first non-repeating using HashMap and switch
public class FindNonRepeatingChar {
    public static void main(String[] args) {
     nonRepChar("aabbcdeff");
     nonRepCharMap("aabbddeeffc");
    }

    public static int index(String s){
        char[] chs=s.toCharArray();
        int[] fre=new int[26];

        for (char ch:chs) {
            fre[ch-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (fre[i]==1){
                return i;
            }
        }
        return 26;
    }
    public static void nonRepChar(String s){
         int i=index(s);
        switch (i) {
            case 0:
                System.out.println("a");
                break;
            case 1:
                System.out.println("b");
                break;
            case 2:
                System.out.println("c");
                break;
            case 3:
                System.out.println("d");
                break;
            case 4:
                System.out.println("e");
                break;
            case 5:
                System.out.println("f");
                break;
            case 6:
                System.out.println("g");
                break;
            case 7:
                System.out.println("h");
                break;
            case 8:
                System.out.println("i");
                break;
            case 9:
                System.out.println("j");
                break;
            case 10:
                System.out.println("k");
                break;
            case 11:
                System.out.println("l");
                break;
            case 12:
                System.out.println("m");
                break;
            case 13:
                System.out.println("n");
                break;
            case 14:
                System.out.println("o");
                break;
            case 15:
                System.out.println("p");
                break;
            case 16:
                System.out.println("q");
                break;
            case 17:
                System.out.println("r");
                break;
            case 18:
                System.out.println("s");
                break;
            case 19:
                System.out.println("t");
                break;
            case 20:
                System.out.println("u");
                break;
            case 21:
                System.out.println("v");
                break;
            case 22:
                System.out.println("w");
                break;
            case 23:
                System.out.println("x");
                break;
            case 24:
                System.out.println("y");
                break;
            case 25:
                System.out.println("z");
                break;
            default:
                System.out.println("#");
                break;
        }
    }
    public static void nonRepCharMap(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i=0;i< ch.length;i++) {
            if (map.get(ch[i])==1) {
                System.out.println(ch[i]);
                break;
            }else if (i==ch.length-1){
                System.out.println("#");
            }

        }

    }
}
