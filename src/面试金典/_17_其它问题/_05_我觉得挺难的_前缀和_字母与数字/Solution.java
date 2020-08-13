package 面试金典._17_其它问题._05_我觉得挺难的_前缀和_字母与数字;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 和 525 题目一样
 */
public class Solution {
    public String[] findLongestSubArray(String[] array) {
        if (array == null || array.length == 0) {
            return new String[0];
        }
        int count = 0;
        int maxL = 0;
        int maxR = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < array.length;i++) {
            char c =array[i].charAt(0);
            if ('0' <= c && c <= '9') {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                int l = map.get(count);
                if (i - l > maxR - maxL) {
                    maxL = l + 1;
                    maxR = i + 1;
                }
            } else {
                map.put(count, i);
            }
        }
        String[] ans = new String[maxR - maxL];
        int p = 0;
        while (maxL < maxR) {
            ans[p++] = array[maxL++];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] array = {"A","1"};
        System.out.println(Arrays.toString(solution.findLongestSubArray(array)));
    }
}
