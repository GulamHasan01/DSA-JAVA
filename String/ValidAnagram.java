package String;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagara"));
    }
    public static boolean isAnagram(String s, String t) {
       int[] fre=new int[26];
       for(char ch:s.toCharArray()){
           fre[ch-'a']++;
       }
        for(char ch:t.toCharArray()){
            fre[ch-'a']--;
        }
        for (int j : fre) {
            if (j >= 1) {
                return false;
            }
        }
        return true;
    }
}
