package 有难度_归并变种_线段树_区间和_逆序对._0327_区间和的个数;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            NavigableMap<Integer, Integer> integerIntegerNavigableMap = map.subMap(sum - upper, true, sum - lower, true);
            for(int n : integerIntegerNavigableMap.values()) {
                ans += n;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        int lower = -2, upper = 2;
        System.out.println(countRangeSum(nums, lower, upper));
    }
}
