package jianZhiOffer._62_我觉得挺难的_圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 初见，用了最笨的方法。。。
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int s = 0;
        while (list.size() > 1) {
            int e = (s + (m - 1)) % list.size();
            list.remove(e);
            s = e;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(10, 17));
    }
}
