package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneKryBoard {
    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        int digit= digits.charAt(0)-'0';
       helper(digits,new StringBuilder(),0,result);
       return result;
    }
    public static void helper(String digits,StringBuilder current,int i,List<String> ans) {
        if (i == digits.length()){
            ans.add(current.toString());
        return;
    }
        int digit= digits.charAt(i)-'0';

        String letters=KEYPAD[digit];

        for (int j = 0; j < letters.length(); j++) {
            current.append(letters.charAt(j));
            helper(digits,current,i+1,ans);
           current.deleteCharAt(current.length()-1);
        }
    }
}
