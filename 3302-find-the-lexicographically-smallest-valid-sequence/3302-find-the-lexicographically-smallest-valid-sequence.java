class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

     
        int[] suf = new int[m];

        int p = n - 1;

        for (int j = m - 1; j >= 0; j--) {

            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }

            if (p < 0) {
                suf[j] = -1;
            } else {
                suf[j] = p;
                p--;
            }
        }

        int[] ans = new int[m];

        int j = 0;              // position in word2
        int mismatches = 0;     // at most 1

        for (int i = 0; i < n && j < m; i++) {

            // Case 1: characters match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            }

            else if (mismatches == 0) {

    
                if (j == m - 1 || suf[j + 1] > i) {

                    ans[j] = i;
                    mismatches++;
                    j++;
                }
            }
        }

        if (j == m) {
            return ans;
        }

        return new int[0];
    }
}
