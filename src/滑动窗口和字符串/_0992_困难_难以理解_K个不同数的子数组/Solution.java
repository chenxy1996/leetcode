package 滑动窗口和字符串._0922_困难_难以理解_K个不同数的子数组;

import java.util.HashMap;
import java.util.Map;


public class Solution {
    public static int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> m = new HashMap<>();//int->count
        int res = 0, dp = 1, p = 0;
        for (int i = 0; i < A.length; i++) {
            if (!m.containsKey(A[i])) m.put(A[i], 1);
            else m.put(A[i], m.get(A[i]) + 1);
            if (m.keySet().size() > K) {
                m.remove(A[p]);
                p++;
                dp = 1;
            }
            if (m.keySet().size() == K) {
                while (m.get(A[p]) > 1) {
                    m.put(A[p], m.get(A[p]) - 1);
                    dp++;
                    p++;
                }
                res += dp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(A, k));
    }
}
