package String;





//                                                    not solved






public class LongestPalindromeSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s){
        char[] ch=s.toCharArray();

        StringBuilder pall=new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            StringBuilder sb=new StringBuilder();
            int j=i;
            while (j<ch.length){
                sb.append(ch[j]);
                StringBuilder temp=sb.reverse();
                if (sb.equals(sb.reverse())){
                    if (pall.length()<sb.length()){
                        pall=sb;
                    }
                }
                j++;
            }
        }
        return pall.toString();
    }
}
