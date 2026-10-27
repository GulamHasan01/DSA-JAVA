class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
        for(int i=0;i<m;i++){
            if(i==0){
                ans[i]=""+".".repeat(n);
            }else{
                ans[i]=""+"#".repeat(n-1)+".";
            }
        }
        return ans;
    }
}