package 树状数组._0315_困难_计算右侧小于当前元素的个数;

import java.util.*;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // 离散化
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : set) {
            map.put(integer, ++rank);
        }

        // 创建离散数组
        int[] tree = new int[rank + 1];

        // 从右往左遍历原来的数组
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentRank = map.get(nums[i]);
            update(tree, currentRank, 1);
            res.add(query(tree, currentRank - 1));
        }

        Collections.reverse(res);
        return res;
    }

    private static int lowBits(int num) {
        return num & -num;
    }

    private static void update(int[] tree, int p, int inc) {
        while (p < tree.length) {
            tree[p] += inc;
            p += lowBits(p);
        }
    }

    private static int query(int[] tree, int p) {
        int res = 0;
        if (p == 0) {
            return 0;
        }

        while (p > 0) {
            res += tree[p];
            p -= lowBits(p);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 5, 7, 1, 4, 7};
        System.out.println(solution.countSmaller(nums));
    }
}
