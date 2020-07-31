package 面试金典._04_树和图问题._02_最小高度树;

import 面试金典._04_树和图问题.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return link(nums, 0, nums.length - 1);
    }

    private static TreeNode link(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int m = i + (j - i) / 2;
        TreeNode curr = new TreeNode(nums[m]);
        curr.left = link(nums, i, m - 1);
        curr.right = link(nums, m + 1, j);
        return curr;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0 ,5, 9};
        new Solution().sortedArrayToBST(nums);
    }
}
