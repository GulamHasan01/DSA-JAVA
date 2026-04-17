package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//finding two sum, sum of two element of an array that would be equal to target
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,13,15},13)));
    }
    public static int[] twoSum(int[] arr, int target){
        Map<Integer,Integer>map=new HashMap<>();

        for (int i = 0; i <arr.length ; i++) {
            int component=target-arr[i];
            if (map.containsKey(component)){
                return new int[]{map.get(component),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
}
