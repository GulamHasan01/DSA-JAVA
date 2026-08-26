class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int start = 0;
        int count = 0;

        String ans = "";

        for (int j = 0; j < s.length(); j++) {

            if (s.charAt(j) == '1') {
                count++;
            }

            while (count == k) {

                String current = s.substring(start, j + 1);

                if (ans.equals("") ||
                    current.length() < ans.length() ||
                    (current.length() == ans.length() && current.compareTo(ans) < 0)) {
                    ans = current;
                }

                if (s.charAt(start) == '1') {
                    count--;
                }

                start++;
            }
        }

        return ans;
    }
}