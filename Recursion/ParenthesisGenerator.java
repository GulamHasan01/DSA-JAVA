package Recursion;

import java.util.ArrayList;

public class ParenthesisGenerator {
    public static void main(String[] args) {
        System.out.println(generate(2));
    }
    public static ArrayList<String> generate(int n){
           ArrayList<String>result=new ArrayList<>();
           helper(n,0,0,"",result);

           return result;
    }

    public static void helper(int n, int o, int c, String ans, ArrayList<String> result){
        if (ans.length()==2*n){
            result.add(ans);
            return;
        }
        if (o<n){
            helper(n,o+1,c,ans+"(",result);
        }
        if (c<o){
            helper(n,o,c+1,ans+")",result);
        }

    }
}
