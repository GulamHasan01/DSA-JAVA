class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        Set<Integer>set=new HashSet<>();

        for(int num:nums){
            set.add(num);
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        int len=max-min+1;
        int miss=Math.abs(len-nums.length);
        
       List<Integer>list=new ArrayList<>();
        for(int i=min+1;i<max;i++){
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }
}