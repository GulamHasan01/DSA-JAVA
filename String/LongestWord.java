package String;

public class LongestWord {
    public static void main(String[] args) {
     String s="my name is Hassan";
        System.out.println(longestWord(s));
        System.out.println(replaceWord(s,"Hassan","Siddique"));
    }

    private static String longestWord(String s) {
        char[] ch=s.toCharArray();
        StringBuilder current= new StringBuilder();

        StringBuilder max = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (s.charAt(i) != ' ') {
                current.append(s.charAt(i));
            } else {

                if (max.length() < current.length()) {
                    max = new StringBuilder(current);
                }

                current.setLength(0);
            }
        }
        if (current.length() > max.length()) {
            max = new StringBuilder(current);
        }
        return max.toString();
    }


    private static String replaceWord(String s,String x,String newword) {
        char[] ch=s.toCharArray();
        StringBuffer current= new StringBuffer();
        StringBuffer result= new StringBuffer();
        for (int i = 0; i < ch.length; i++) {
            if (s.charAt(i) != ' ') {
                current.append(s.charAt(i));
            } else {

                if (current.toString().equals(x)) {
                  result.append(newword);
                }else{
                    result.append(current);
                }
                result.append(" ");
                current.setLength(0);
            }
        }
        if (current.toString().equals(x)) {
            result.append(newword);
        } else {
            result.append(current);
        }
        return result.toString();
    }
}
