package jianZhiOffer._39有趣的解法_数组出现次数超过一半的数字;

import java.util.HashMap;

public class Solution {
    // 最好的方法：摩尔投票法
    public int majorityElement(int[] nums) {
        int x = 0;
        int weight = 0;
        for (int i = 0; i < nums.length; i++) {
            if (weight == 0) {
                x = nums[i];
                weight++;
            } else {
                if (nums[i] == x) {
                    weight++;
                } else {
                    weight--;
                }
            }
        }
        return x;
    }

    // 利用哈希表
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            int count = hashMap.getOrDefault(num, 0) + 1;
            if (count > nums.length / 2) {
                return num;
            }
            hashMap.put(num, count);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement1(new int[] {2,2,1,1,1,2,2}));
    }
}
