package String;

public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString( "abcde", "cdeab"));
    }
    public static boolean rotateString(String s, String goal) {

        if (s.length()!=goal.length()) return false;
        if(s.equals(goal)) return true;

        int i=1;
        int n=s.length()-1;
        while(i<n){
            String temp=s.substring(i)+s.substring(0,i);
            System.out.println(temp);
            if(temp.equals(goal)) return true;
            i++;
        }
        return false;
    }
}
