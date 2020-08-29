package 滑动窗口和字符串.至多包含K个不同字符的最长子串;

import java.util.HashMap;

public class Solution {
    private static int numberOfNotMoreThan(int[] nums, int n) {
        int l = 0;
        int r = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > n) {
                int leftVal = nums[l];
                if (map.get(leftVal) == 1) {
                    map.remove(leftVal);
                } else {
                    map.put(leftVal, map.get(leftVal) - 1);
                }
                l++;
            }
            r++;
            ans += r - l;
        }
        return ans;
    }
}
