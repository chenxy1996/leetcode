package jianZhiOffer._61_1_我觉得挺难的_扑克牌中的顺子;

import java.util.Arrays;

// 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的.
// 2到10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可
// 以看成任意数字。A 不能视为 14。

/**
 * 这波我想复杂了, 之前我是以为会有循环的也就是尾巴接着头的情况
 */
public class Solution {
    public static boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,3,12};
        System.out.println(isStraight(nums));
    }
}
