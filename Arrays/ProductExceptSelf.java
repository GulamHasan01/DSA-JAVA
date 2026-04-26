package Arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4, 5})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] result= new int[nums.length];
        result[0]=1;
        for (int i = 1; i < nums.length; i++) {
           result[i]=result[i-1]*nums[i-1];
        }

        int suffix=1;
        for (int j = nums.length-1; j >=0 ; j--) {
            result[j]*=suffix;
            suffix*=nums[j];
        }
        return result;
    }
}
