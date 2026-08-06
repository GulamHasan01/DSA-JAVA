class Solution {
    public int smallestNumber(int n, int t) {
        int ref=n;
        int p=1;
        int i=0;
        while(true){
            p=prod(ref+i,1);
             if(p%t==0){
            return ref+i;
        }
        i++;
        }
    }

    private int prod(int n,int ans){
        if(n==0){
            return ans;
        }
        int rem=n%10;
        ans=ans*rem;
        return prod(n/10,ans);
    
    }
}