package dfs._1553_困难_吃掉N个橘子的最少天数;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    // 这道题用 dp 肯定超时
    public int minDays(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 2);
        return dfs(n);
    }

    private int dfs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = Math.min(
                dfs(n / 3) + n % 3,
                dfs(n / 2) + n % 2
        ) + 1;
        map.put(n, res);
        return res;
    }
}
