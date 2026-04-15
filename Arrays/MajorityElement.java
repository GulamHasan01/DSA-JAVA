package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,2,2,3,2,1,2,3,2,2}));
    }
    public static int majorityElement(int[] nums) {
        int major=0;
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
           map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num: map.keySet()){
           if (major<map.get(num)){
               major=map.get(num);
               ans=num;
           }
        }
        return ans;
    }
}
