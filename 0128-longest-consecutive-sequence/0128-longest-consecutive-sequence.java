class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer>set=new HashSet<>();
      int count=1;
        for(int num:nums){
            set.add(num);
        }

        for(int num:set){
            if(set.contains(num-1)) continue;
            
            if(set.contains(num+1)){
                int n=num;
              int c=1;
            while(set.contains(n+1)){
                c++;
                n=n+1;
            }
            count=Math.max(c,count);
        }
        
        }
        return count;
    }
}