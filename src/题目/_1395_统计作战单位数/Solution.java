package 题目._1395_统计作战单位数;

public class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        for(int i = 0; i < rating.length; i++) {
            int ll = 0, lh = 0;
            int rl = 0, rh = 0;
            for(int j = 0; j < i - 1; j++) {
                if (rating[j] < rating[i]) {
                    ll++;
                } else {
                    lh++;
                }
            }
            for(int j = rating.length - 1; j > i; j--) {
                if (rating[j] < rating[i]) {
                    rl++;
                } else {
                    rh++;
                }
            }
            ans += ll * rh + lh * rl;
        }
        return ans;
    }
}
