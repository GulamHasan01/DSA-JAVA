package Arrays;

import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, 1, 2}, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}