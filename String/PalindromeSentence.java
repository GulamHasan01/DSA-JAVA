package String;

public class PalindromeSentence {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s) {
     StringBuilder helper= new StringBuilder();
     for (char ch:s.toCharArray()){
         if (Character.isLetterOrDigit(ch)){
             helper.append(Character.toLowerCase((char)ch));
         }

     }
     String given=helper.toString();
     String ans= helper.reverse().toString();

        return ans.equals(given);
    }
}
