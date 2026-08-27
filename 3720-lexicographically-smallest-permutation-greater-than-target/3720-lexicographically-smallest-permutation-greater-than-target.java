class Solution {
    public String lexGreaterPermutation(String s, String t) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < t.length(); i++) {
            int target = t.charAt(i) - 'a';

            if (freq[target] > 0) {
                freq[target]--;
                ans.append(t.charAt(i));
            } else {
                for (int c = target + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        freq[c]--;
                        ans.append((char) ('a' + c));

                        for (int x = 0; x < 26; x++) {
                            while (freq[x] > 0) {
                                ans.append((char) ('a' + x));
                                freq[x]--;
                            }
                        }

                        return ans.toString();
                    }
                }
                break;
            }
        }

        for (int i = ans.length() - 1; i >= 0; i--) {
            int current = ans.charAt(i) - 'a';
            freq[current]++;

            for (int c = current + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    StringBuilder res = new StringBuilder(ans.substring(0, i));
                    res.append((char) ('a' + c));
                    freq[c]--;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            res.append((char) ('a' + x));
                            freq[x]--;
                        }
                    }

                    return res.toString();
                }
            }
        }

        return "";
    }
}