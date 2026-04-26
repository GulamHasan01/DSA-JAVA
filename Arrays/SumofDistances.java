package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumofDistances {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distance(new int[]{1, 3, 1, 1, 2})));
    }
    public static long[] distance(int[] nums) {

        Map<Integer, ArrayList<Integer>>map=new HashMap<>();
        long[] ans=new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for (ArrayList<Integer> list : map.values()) {

            int size = list.size();
            long[] prefix = new long[size];

            prefix[0] = list.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for (int i = 0; i < size; i++) {
                int idx = list.get(i);

                long left = (long) list.get(i) * i - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[size - 1] - prefix[i]) - (long) list.get(i) * (size - i - 1);

                ans[idx] = left + right;
            }
        }

        return ans;
    }
}
