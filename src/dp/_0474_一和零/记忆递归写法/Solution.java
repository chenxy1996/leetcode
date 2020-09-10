package dp._0474_一和零;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zero = new int[len];
        int[] one = new int[len];

        for(int i = 0; i < len; i++) {
            String s = strs[i];
            zero[i] = countZero(s);
            one[i] = s.length() - zero[i];
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("0|0|0", 0);

        return dfs(m, n, 0, zero, one, new HashMap<>());

    }

    private int dfs(int m, int n, int i, int[] zero, int[] one, Map<String, Integer> map) {
        if (i >= zero.length) {
            return 0;
        }

        String key = m + "|" + n + "|" + i;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ans;
        if (zero[i] <= m && one[i] <= n) {
            ans =  Math.max(1 + dfs(m - zero[i], n - one[i], i + 1, zero, one, map), dfs(m, n, i + 1, zero, one, map));
        } else {
            ans = dfs(m, n, i + 1, zero, one, map);
        }

        map.put(key, ans);

        return ans;
    }

    private int countZero(String s) {
        int ans = 0;
        for(char c : s.toCharArray()) {
            if (c == '0') {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"0","1101","01"};
        int m = 3;
        int n = 9;
        System.out.println(new Solution().findMaxForm(s, m, n));
    }
}
