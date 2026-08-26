class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;
        int j = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        while (j < s.length()) {

            char ch = s.charAt(j);
            sb.append(ch);

            if (ch == '1') {
                count++;
            }

            while (count == k) {

                String current = sb.toString();

                set.add(current);
                min = Math.min(min, current.length());

                char l = sb.charAt(0);
                sb.deleteCharAt(0);

                if (l == '1') {
                    count--;
                }

                start++;

                // Remove leading zeros
                while (start <= j && sb.length() > 0 && sb.charAt(0) == '0') {
                    sb.deleteCharAt(0);
                    start++;
                }
            }

            j++;
        }

        // Find shortest strings
        String ans = "";

        for (String ss : set) {

            if (ss.length() == min) {

                if (ans.equals("") || ss.compareTo(ans) < 0) {
                    ans = ss;
                }
            }
        }

        return ans;
    }
}