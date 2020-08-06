package 剑指offer._51树状数组_数组中的逆序对;

import java.util.*;

public class Solution {
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        int ret = 0;

        // 排序 + 去重
        // [7, 3, 2, 6, 1]
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 离散化
        // [7, 3, 2, 6, 1]
        // 离散成 ====>
        // [5, 3, 2, 4, 1]
        // {7:5, 3:3, 2:2, 6:4, 1:1}
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : set) {
            map.put(integer, ++rank);
        }

        // 树状数组
        int[] tree = new int[rank + 1];

        // 从右往左遍历原来的数组
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentRank = map.get(nums[i]);
            // 更新树状数组
            update(tree, currentRank, 1);
            // 查询树状数组某像的值
            // 此时树状数组中小于当前 currentRank 值的数字的数量
            ret += query(tree, currentRank - 1);
        }

        return ret;
    }

    private static int lowBits(int num) {
        return num & -num;
    }

    // 更新树状数组
    private static void update(int[] tree, int p, int inc) {
        if (p < 1) {
            return;
        }

        while (p < tree.length) {
            tree[p] += inc;
            p += lowBits(p);
        }
    }

    private static int query(int[] tree, int p) {
        if (p >= tree.length || p == 0) {
            return 0;
        }

        int res = 0;

        while (p >= 1) {
            res += tree[p];
            p -= lowBits(p);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 7, 1, 4, 7};
        System.out.println(reversePairs(nums));
    }
}
