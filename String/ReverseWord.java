package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Reverse words in-place and using extra space for each word

public class ReverseWord {
    public static void main(String[] args) {
        System.out.println(reverseWords("hello gulam hasan"));
    }
    public static String revWord(String s){
        List<String>list=new ArrayList<>();
        StringBuilder ans= new StringBuilder();
          int j=s.length();
        for (int i = s.length()-1; i >=0 ; i--) {

            if (s.charAt(i)==' '){
                list.add(s.substring(i+1,j));
                j=i;
            }

        }
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i)==' '){
                list.add(s.substring(0,i));
                break;
            }
        }
        for (int i = 0; i < list.size() ; i++) {
            ans.append(list.get(i));
            if (i!=list.size()-1) ans.append(' ');
        }
        return ans.toString();
    }

    public static String revWord1(String s) {
        char[] arr = s.toCharArray();

        // 1. reverse whole string
        reverse(arr, 0, arr.length - 1);

        int start = 0;

        // 2. reverse each word
        for (int end = 0; end <= arr.length; end++) {
            if (end == arr.length || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }

        return new String(arr);
    }

    private static void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    public static String reverseWords(String s) {
      String[] words=s.trim().split("\\s+");
      int j= words.length-1;
      int i=0;

     while (j>i){
          String temp=words[i];
          words[i]=words[j];
          words[j]=temp;
         j--;
         i++;
      }

      return String.join(" ",words);
    }
}
