package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PartionPivort {
    public static void main(String[] args) {
        int[] arr={9,12,5,10,14,3,10};
        System.out.println(Arrays.toString(pivotArray(arr, 10)));
    }
    public static int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer>smaller=new ArrayList<>();
        ArrayList<Integer>equall=new ArrayList<>();
        ArrayList<Integer>greater=new ArrayList<>();

        for (int num:nums){
            if (num>pivot) greater.add(num);
            else if (num<pivot) smaller.add(num);
            else equall.add(num);
        }

        for (int i = 0; i < smaller.size(); i++) {
            nums[i]=smaller.get(i);
        }
        int j=0;
        for (int i = smaller.size(); i <smaller.size()+equall.size(); i++) {
            nums[i]=equall.get(j++);

        }

        int k=0;
        for (int i = smaller.size()+equall.size(); i < nums.length ; i++) {
            nums[i]= greater.get(k++);
        }
        return nums;
    }
}
