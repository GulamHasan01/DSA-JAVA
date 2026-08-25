class Solution {
    public int missingMultiple(int[] nums, int k) {
        // HashSet<Integer>set=new HashSet<>();
        // for(int num:nums){
        //     set.add(num);
        // }
         int ref=k;
        // while(set.contains(k)){
        //     k=k+ref;
        // }
        // return k;

        Arrays.sort(nums);
        int i=0;
       while(i<nums.length){
    if(nums[i]==k){
            k=k+ref;
            
        }
     i++;
       }
         return k;
    }
}