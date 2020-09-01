package 树状数组._493_翻转对;

import java.util.Arrays;

public class Solution1 {
    public int reversePairs(int[] nums) {
        int res = 0;

        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int[] tree = new int[nums.length + 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            int order1 = lowerBound(sortedNums, n) + 1;

            int half = (nums[i] - 1) >> 1;
            int order2 = lowerBound(sortedNums, half) + 1;

            res += query(tree, order2);
            update(tree, order1);
        }

        return res;
    }

    private static int lowBits(int x) {
        return x & (-x);
    }

    private static int query(int[] tree, int p) {
        int res = 0;
        while (p > 0) {
            res += tree[p];
            p -= lowBits(p);
        }

        return res;
    }

    private static void update(int[] tree, int p) {
        while (p <= tree.length - 1) {
            tree[p] += 1;
            p += lowBits(p);
        }
    }
    /**
     *  nums = [1, 3, 4, 6, 8, 10]
     *  val = 4, return 2
     *  val = 5, return 2
     *  val = -1, return -1
     *  val = 7, return 3
     */
    public static int lowerBound(int[] sortedArray, int val) {
        int s = 0;
        int e = sortedArray.length - 1;
        int mid;
        while (s <= e) {
            if (sortedArray[s] == val)
                return s;
            mid = s + ((e - s) >> 1);
            if (sortedArray[mid] < val) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        if (s >= sortedArray.length) {
            return sortedArray.length - 1;
        }

        if (s == 0 && sortedArray[0] != val) {
            return -1;
        }

        if (sortedArray[s] == val) {
            return s;
        }

        return s - 1;
    }

    public static void main(String[] args) {
//        System.out.println(lowerBound(new int[]{-3, -3, -3, 3, 3, 3}, 3));
//        int[] nums = {1, 2, 3, 3, 3, 4, 4, 4, 5};

        int[] nums = {5, 2, 3, -4, -2, 1};
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(lowerBound(nums, 4));

        Solution solution = new Solution();
        System.out.println(solution.reversePairs(nums));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.reversePairs(nums));
    }
}
