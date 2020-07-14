package 字节跳动._1512_好数对的数目;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int val = nums[i];
            int count = map.getOrDefault(val, 0);
            res += count;
            map.put(val, ++count);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1,1,3};
        System.out.println(solution.numIdenticalPairs(nums));
    }
}
