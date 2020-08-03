package 面试金典._08_递归问题._13_困难_堆箱子;

import java.util.Arrays;
import java.util.Comparator;

public class AnotherSolution {
    public int pileBox(int[][] box) {
        int len = box.length;
        int[] dp = new int[len];
        int res = 0;
        Arrays.sort(box, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < box.length; i++) {
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], box[i][2] + dp[j]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] box = {
                {1,1,1},
                {2,3,4},
                {2,6,7},
                {3,4,5}
        };
        System.out.println(new AnotherSolution().pileBox(box));
    }
}
