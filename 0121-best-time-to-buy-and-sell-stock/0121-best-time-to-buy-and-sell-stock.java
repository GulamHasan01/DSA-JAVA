class Solution {
    public int maxProfit(int[] prices) {
       int buy=Integer.MAX_VALUE;
       int prof=0;;
       for(int i=0;i<prices.length;i++){
       if(prices[i]<buy){
        buy=prices[i];
       }else{
         prof=Math.max(prof,prices[i]-buy);
       }
       }
     return prof;
    }
}