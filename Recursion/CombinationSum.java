package Recursion;
import java.util.*;
// finding combination sum in given array
public class CombinationSum {

        public List<List<Integer>> combinationSum(int[] arr, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(arr);
            helper1(arr, 0, target, new ArrayList<>(), result);
            return result;
        }

        public void helper1(int[] arr, int i, int target,
                           List<Integer> current, List<List<Integer>> result) {

            // base case
            if (target == 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            if (i > 0 && arr[i] == arr[i-1]) return;
            if (i == arr.length || target < 0) {
                return;
            }

            // include (same index because reuse allowed)
            current.add(arr[i]);
            helper1(arr, i, target - arr[i], current, result);

            // backtrack
            current.remove(current.size() - 1);

            // exclude (move to next index)
            helper1(arr, i + 1, target, current, result);

    }


    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        // code here
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        helper(arr,target,0, result, new ArrayList<>());

        return result;
    }

    public void helper(int [] arr,int target,int index,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> ans){

        if(target==0){
            result.add(ans);
            return;

        }

        if(target<0 || index==arr.length-1){
            return;
        }

        ans.add(arr[index]);
        helper(arr,target-arr[index],index, result, ans);

        ans.remove(ans.size()-1);

        helper(arr,target,index+1, result, ans);
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        helper(candidates,target,0, result, new ArrayList<>());

        return result;
    }

    public void helper(int [] arr,int target,int index,List<List<Integer>> result,List<Integer> ans){


        if(target==0){
            for (int i = 0; i < ans.size()-1; i++) {
                if (!new HashSet<>(ans).containsAll(result.getLast())){
                    result.add(new ArrayList<>(ans));
                }
            }
            return;

        }

        if(target<0 || index==arr.length){
            return;
        }

        ans.add(arr[index]);
        helper(arr,target-arr[index],index+1, result, ans);


        ans.remove(ans.size()-1);

        helper(arr,target,index+1, result, ans);
    }


}
