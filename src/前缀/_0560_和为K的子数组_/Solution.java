package 前缀._0560_和为K的子数组_;

import java.util.HashMap;
import java.util.Map;

/**
 * 和 _1524_, 剑指 offer _34_02_ 差不多
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int num : nums) {
            sum += num;
            int delta = sum - k;
            ans += map.getOrDefault(delta, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
