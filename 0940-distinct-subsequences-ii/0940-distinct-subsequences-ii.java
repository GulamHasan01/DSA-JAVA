class Solution {
    public int distinctSubseqII(String s) {

        long MOD = 1_000_000_007;
        long dp = 0;

        long[] last = new long[26];

        for (char c : s.toCharArray()) {

            int idx = c - 'a';

            long newDp = (2 * dp + 1 - last[idx] + MOD) % MOD;

            last[idx] = (dp + 1) % MOD;

            dp = newDp;
        }

        return (int) dp;
    }
}