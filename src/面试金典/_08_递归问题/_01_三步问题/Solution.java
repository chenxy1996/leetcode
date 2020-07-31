package 面试金典._08_递归问题._01_三步问题;

import java.util.HashMap;
import java.util.Map;

/**
 * 添加一个记忆化 map;
 * 过不了，不知道为什么
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }
        return dfs(n);
    }

    private int dfs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans;
        if (n <= 1) {
            ans = 1;
        } else if (n == 2) {
            ans = 2;
        } else {
            ans = (dfs(n - 3) % 1000000007
                    + (dfs(n - 2) % 1000000007
                    + dfs(n - 1) % 1000000007) % 1000000007) % 1000000007;
        }
        map.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToStep(61));
    }
}
