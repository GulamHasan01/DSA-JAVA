class Solution {
    public int maxScore(int[] num, int k) {
        int result=0;
        int suff=0;
        int j=num.length-1;
        int ref=k;
        while(k>0){
            suff=suff+num[j--];
            k--;
        }
        result=Math.max(result,suff);
        for(int i=0;i<ref;i++ ){
            int idx=num.length-ref+i;
            suff=suff-num[idx]+num[i];
             result=Math.max(result,suff);
        }
        return result;
    }
}