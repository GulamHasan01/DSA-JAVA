import java.util.Arrays;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;
        int[] cnt = new int[26];
        
        
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        

        int oddCharIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                if (oddCharIdx != -1) return ""; 
                oddCharIdx = i;
            }
        }
        
       
        if (n % 2 == 0 && oddCharIdx != -1) return "";
       
        if (n % 2 != 0 && oddCharIdx == -1) return "";
        
       
        if (oddCharIdx != -1) {
            cnt[oddCharIdx]--;
        }
        
       
        int[] leftCnt = new int[26];
        for (int i = 0; i < 26; i++) {
            leftCnt[i] = cnt[i] / 2;
        }
        
        char[] leftHalf = new char[half];
        
        
        int matchLen = 0;
        while (matchLen < half) {
            int tChar = target.charAt(matchLen) - 'a';
            if (leftCnt[tChar] > 0) {
                leftHalf[matchLen] = (char) (tChar + 'a');
                leftCnt[tChar]--;
                matchLen++;
            } else {
                break;
            }
        }
        
       
        for (int i = matchLen; i >= 0; i--) {
          
            if (i < matchLen) {
                int prevChar = leftHalf[i] - 'a';
                leftCnt[prevChar]++;
            }
            
            int targetChar = (i < half) ? (target.charAt(i) - 'a') : -1;
            
           
            for (int nextChar = targetChar + 1; nextChar < 26; nextChar++) {
                if (leftCnt[nextChar] > 0) {
                    leftHalf[i] = (char) (nextChar + 'a');
                    leftCnt[nextChar]--;
                    
                   
                    int fillIdx = i + 1;
                    for (int c = 0; c < 26; c++) {
                        while (leftCnt[c] > 0) {
                            leftHalf[fillIdx++] = (char) (c + 'a');
                            leftCnt[c]--;
                        }
                    }
                    
                    return buildFullPalindrome(leftHalf, oddCharIdx);
                }
            }
            
     
            if (i == half) {
                String fullCandidate = buildFullPalindrome(leftHalf, oddCharIdx);
                if (fullCandidate.compareTo(target) > 0) {
                    return fullCandidate;
                }
            }
        }
        
        return "";
    }
    
    private String buildFullPalindrome(char[] leftHalf, int oddCharIdx) {
        StringBuilder sb = new StringBuilder(new String(leftHalf));
        String left = sb.toString();
        if (oddCharIdx != -1) {
            sb.append((char) (oddCharIdx + 'a'));
        }
        sb.append(new StringBuilder(left).reverse());
        return sb.toString();
    }
}
