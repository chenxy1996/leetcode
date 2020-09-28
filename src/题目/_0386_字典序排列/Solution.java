package 题目._0386_字典序排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int cur=1;
        for(int i=0;i<n;i++){
            ans.add(cur);
            if(cur*10<=n){
                cur*=10;
            }else{
                if(cur>=n) cur/=10;
                cur+=1;
                while(cur%10==0) cur/=10;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(20));
    }
}
