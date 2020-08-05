package 面试金典._17_动态规划._10_主要元素;

/**
 * 就是求众数
 * 利用摩尔投票法
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int x = 0;
        int weight = 0;
        for (int num : nums) {
            if (weight == 0) {
                weight = 1;
                x = num;
            } else {
                if (num == x) {
                    weight++;
                } else {
                    weight--;
                }
            }
        }
        weight = 0;
        for (int num : nums) {
            if (num == x) {
                weight++;
            }
        }
        return weight > nums.length / 2 ? x : -1;
    }
}
