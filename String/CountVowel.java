package String;

public class CountVowel {
    public static void main(String[] args) {
        System.out.println(vowel("abcdef"));
    }

    private static int[] vowel(String s) {
        char[] ch=s.toCharArray();
        int[] arr=new int[2];

        for (int i = 0; i < ch.length; i++) {
            if (ch[i]=='a' || ch[i]=='e' || ch[i]=='i' ||ch[i]=='o' || ch[i]=='u'
              ||  ch[i]=='A' || ch[i]=='E' || ch[i]=='I' ||ch[i]=='O' || ch[i]=='U'){
              arr[0]++;
            }else arr[1]++;
        }
        return arr;
    }
}
