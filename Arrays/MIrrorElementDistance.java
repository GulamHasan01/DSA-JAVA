package Arrays;

import java.util.HashMap;
  //finding mirror element distance
public class MIrrorElementDistance {
    public static void main(String[] args) {
        System.out.println(minMirrorPairDistance(new int[]{10101,12,21,54,45,10101}));
    }

    public static int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int diff=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
          int rev= reverse(nums[i]);
            if (map.containsKey(rev)){
                diff=Math.min(diff,Math.abs(map.get(rev)-i));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return diff == Integer.MAX_VALUE ? -1 : diff;
    }
    public static int reverse(int element){
        int ans=0;
        while (element>0) {
            int rem = element % 10;
            ans = ans * 10 + rem;
            element/=10;
        }
        return ans;
    }
}
