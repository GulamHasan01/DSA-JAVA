package Recursion;

import java.util.ArrayList;

public class recurssionArraylistbased {

    public static void main(String[] args) {
      int []arr={1,2,3,5,5,6,7,6,9};
      ArrayList<Integer>list= new ArrayList<>();
        System.out.println(cheak(arr,6,0,list));
        System.out.println(cheak(arr,6,0));
        System.out.println(cheak2(arr,5,0));
       // System.out.println(list);

    }


    public static boolean cheak(int []arr, int target, int index) {
       if (index==arr.length-1){
           return false;
       }
       if (arr[index]==target ){
        //   System.out.println(index);
           return true;
       }

       return cheak(arr,target,index+1);
    }

    public static ArrayList<Integer> cheak(int []arr, int target, int index, ArrayList<Integer> list) {
        if (index==arr.length-1){
            return list;
        }
        if (arr[index]==target ){
            list.add(index);

        }

        return cheak(arr,target,index+1,list);
    }

    public static ArrayList<Integer> cheak2(int []arr, int target, int index ) {
        ArrayList<Integer> list=new ArrayList<>();
        if (index==arr.length-1){
            return list;
        }
        if (arr[index]==target ){
            list.add(index);

        }

        ArrayList<Integer> ansfrombelowlist= cheak2(arr,target,index+1);
       list.addAll(ansfrombelowlist);
       return list;
    }
}
