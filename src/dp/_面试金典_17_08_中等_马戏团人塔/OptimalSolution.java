package dp._面试金典_17_08_中等_马戏团人塔;

import java.util.Arrays;

/**
 * 这是别人写得
 */
public class OptimalSolution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        for(int i = 0; i < height.length ; i++) {
            height[i] = (height[i] << 16) + (65535 - weight[i]);
        }
        Arrays.parallelSort(height);
        int res = 0;
        int dp[] = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            int w = 65535 - (height[i] & 65535);
            int t= Arrays.binarySearch(dp, 0,res,w);
            if(t<0) t=-(t+1);
            dp[t]=w;
            if(t==res) {
                res++;
            }
        }
        return res;
    }
}
