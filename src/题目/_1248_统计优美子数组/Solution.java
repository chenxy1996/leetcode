package 题目._1248_统计优美子数组;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(0, 1);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                cnt++;
            }
            int delta = cnt - k;
            ans += map.getOrDefault(delta, 0);
            map.put(cnt, map.getOrDefault(cnt, 0) + 1);
        }
        return ans;
    }
}
