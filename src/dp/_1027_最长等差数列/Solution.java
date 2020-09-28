package dp._1027_最长等差数列;

import java.util.HashMap;
import java.util.Map;

/**
 * 和最长斐波那契数列差不多
 * 跟最长的斐波那契子序列解法相似，
 * 不同点在于斐波那契数列题目中原数组没有重复原理，此题有重复元素，
 * 所以只能一边遍历一边给hash字典填加
 */
public class Solution {
    public static int longestArithSeqLength(int[] A) {
        int ans = 2;
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> length = new HashMap<>();
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int delta = A[i] - (A[j] - A[i]);
                int p = map.getOrDefault(delta, -1);
                if (p >= 0 && p < i) {
                    int l = length.get(p * len + i);
                    length.put(i * len + j, l + 1);
                    ans = Math.max(ans, l + 1);
                } else {
                    length.put(i * len + j, 2);
                }
            }
            map.put(A[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 12};
        System.out.println(longestArithSeqLength(nums));
    }
}
