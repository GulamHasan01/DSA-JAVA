class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] fre = new int[value];

        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            fre[mod]++;
        }
        int x = 0;
        while (true) {
            int mod = x % value;

            if (fre[mod] > 0) {
                fre[mod]--;
            } else {
                return x;
            }

            x++;
        }

    }
}