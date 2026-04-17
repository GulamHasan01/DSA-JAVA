package String;

import java.util.Arrays;
// Count frequency of each character and print only those present
public class CountFre {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(freqCount("abcdefl")));
    }

    private static int[] freqCount(String s) {
        char[] ch=s.toCharArray();
        int[] fre=new int[26];

        for (char chh : ch) {
            if (chh==' ') continue;
            fre[chh-'a']++;
        }
        int i=0;
        int count=0;
        while (i<fre.length){
            if (fre[i]>0){
                System.out.print((char)(i+'a')+" ");
              count++;
            }
            i++;
        }
        System.out.println();
        int[] ans=new int[count];
        int idx = 0;

        for (int f : fre) {
            if (f > 0) {

                ans[idx++] = f;
            }
        }

        return ans;
    }
}
