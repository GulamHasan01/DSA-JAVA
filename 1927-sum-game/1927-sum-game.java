class Solution {
    public boolean sumGame(String num) {

        int mid = num.length() / 2;

        int fc = countQ(num, 0, mid, 0);
        int sc = countQ(num, mid, num.length(), 0);

        int fs = sum(num, 0, mid, 0);
        int ss = sum(num, mid, num.length(), 0);

        if ((fc + sc) % 2 == 1)
            return true;

      
        return fs - ss != 9 * (sc - fc) / 2;
    }

    private int countQ(String s, int start, int end, int count) {
        if (start == end)
            return count;

        if (s.charAt(start) == '?')
            count++;

        return countQ(s, start + 1, end, count);
    }

    private int sum(String s, int start, int end, int ans) {
        if (start == end)
            return ans;

        if (s.charAt(start) != '?')
            ans += s.charAt(start) - '0';

        return sum(s, start + 1, end, ans);
    }
}
