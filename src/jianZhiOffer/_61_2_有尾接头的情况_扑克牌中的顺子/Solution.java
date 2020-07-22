package jianZhiOffer._61_2_有尾接头的情况_扑克牌中的顺子;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 能从尾接到头的情况
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int p = 0;
        // 统计开头的0的数量
        int zeroCount = 0;
        while (nums[p] == 0) {
            zeroCount++;
            p++;
        }
        // 把数组想象成一个环，统计两个之间的间隔
        List<Integer> gaps = new ArrayList<>();
        int gapsSum = 0;
        for (int i = p + 1; i < 5; i++) {
            int gap = nums[i] - nums[i - 1];
            if (gap == 0) {
                // 有重复的肯定就不可能为顺子
                return false;
            } else if (gap > 1) {
                gapsSum += gap - 1;
                gaps.add(gap - 1);
            }
        }
        // 最后一个数和开头数之间的间隔
        int tailToHead = 13 - nums[4] + nums[p] - 1;
        gapsSum += tailToHead;
        gaps.add(tailToHead);

        for (int i = 0; i < gaps.size(); i++) {
            int remain = gapsSum - gaps.get(i);
            if (remain <= zeroCount) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {11, 0, 0, 0, 2};
        System.out.println(isStraight(nums));
    }
}
