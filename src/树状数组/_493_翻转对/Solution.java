<<<<<<< HEAD
package 树状数组._493_翻转对;

import java.util.*;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 */
public class Solution {
    public int reversePairs(int[] nums) {
        int res = 0;

        // 排序 + 去重
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 散列化
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : set) {
            map.put(integer, ++rank);
        }

        // 初始化树状数组
        int[] tree = new int[map.size() + 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            // nums[i] 在 tree 中的位置, 即 tree 数组的下标
            int currentRank = map.get(nums[i]);

            // 寻找小于当前 nums[i] 一半的数字
            int half;
            /**
             * 不能用 (nums[i] - 1) / 2!!!
             * 此时 nums[i] <= 0, 例如 此时若 nums[i] = 0
             * 按照数学上来说为 (0 - 1) / 2 为 -1 , 但是在 java 上 (0 - 1) / 2 为 0
             * 要实现数学上的 (nums[i] - 1) / 2
             * 使用 (nums[i]) >> 1
             */
            half = (nums[i] - 1) >> 1;
            // half 不一定在 nums 中存在, 所以要寻找 nums 中小于等于 half 的第一个数
            // 并找到该数在 tree 数组的下标 maxRank
            int max;
            int maxRank;
            try {
                max = set.floor(half);
                maxRank = map.get(max);
            } catch (NullPointerException npe) {
                // 有可能 nums 中没有 小于等于 half 的数了
                max = 0;
                maxRank = 0;
            }

            res += query(tree, maxRank);
            update(tree, currentRank);
        }

        return res;
    }

    private static int lowbit(int x) {
        return x & -x;
    }

    private static int query(int[] tree, int x) {
        int sum = 0;
        while(x > 0){
            sum += tree[x];
            x -= lowbit(x);
        }
        return sum;
    }

    private static void update(int[] tree, int x) {
        while(x <= tree.length - 1){
            tree[x] += 1;
            x += lowbit(x);
        }
    }

    private static int count(int[] sortArr, int val) {
        int l = 0,r = sortArr.length - 1,m = 0;
        while(l <= r){
            m = l + ((r - l) >> 1);
            if(sortArr[m] >= val){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return l + 1;
    }


    public static void main(String[] args) {
        int[] nums = {-5, -5};
//        System.out.println(count(nums, ));
//        Solution solution = new Solution();
//        System.out.println(solution.reversePairs(nums));
    }
}
=======
package 树状数组._493_翻转对;

import java.util.*;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 */
public class Solution {
    public int reversePairs(int[] nums) {
        int res = 0;

        // 排序 + 去重
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 散列化
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : set) {
            map.put(integer, ++rank);
        }

        // 初始化树状数组
        int[] tree = new int[map.size() + 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            // nums[i] 在 tree 中的位置, 即 tree 数组的下标
            int currentRank = map.get(nums[i]);

            // 寻找小于当前 nums[i] 一半的数字
            int half;
            /**
             * 不能用 (nums[i] - 1) / 2!!!
             * 此时 nums[i] <= 0, 例如 此时若 nums[i] = 0
             * 按照数学上来说为 (0 - 1) / 2 为 -1 , 但是在 java 上 (0 - 1) / 2 为 0
             * 要实现数学上的 (nums[i] - 1) / 2
             * 使用 (nums[i]) >> 1
             */
            half = (nums[i] - 1) >> 1;
            // half 不一定在 nums 中存在, 所以要寻找 nums 中小于等于 half 的第一个数
            // 并找到该数在 tree 数组的下标 maxRank
            int max;
            int maxRank;
            try {
                max = set.floor(half);
                maxRank = map.get(max);
            } catch (NullPointerException npe) {
                // 有可能 nums 中没有 小于等于 half 的数了
                max = 0;
                maxRank = 0;
            }

            res += query(tree, maxRank);
            update(tree, currentRank);
        }

        return res;
    }

    private static int lowbit(int x) {
        return x & -x;
    }

    private static int query(int[] tree, int x) {
        int sum = 0;
        while(x > 0){
            sum += tree[x];
            x -= lowbit(x);
        }
        return sum;
    }

    private static void update(int[] tree, int x) {
        while(x <= tree.length - 1){
            tree[x] += 1;
            x += lowbit(x);
        }
    }

    private static int count(int[] sortArr, int val) {
        int l = 0,r = sortArr.length - 1,m = 0;
        while(l <= r){
            m = l + ((r - l) >> 1);
            if(sortArr[m] >= val){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return l + 1;
    }


    public static void main(String[] args) {
        int[] nums = {-5, -5};
//        System.out.println(count(nums, ));
//        Solution solution = new Solution();
//        System.out.println(solution.reversePairs(nums));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
