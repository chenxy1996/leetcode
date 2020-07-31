package 面试金典._04_树和图问题._09_困难_二叉搜索树序列;

import 面试金典._04_树和图问题.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 初见没有写出来
 * 下面通过了，但是速度很慢，可以改进
 */
public class Solution {
    public List<List<Integer>> BSTSequences(TreeNode root) {
        return generate(root);
    }

    private List<List<Integer>> generate(TreeNode root) {
        if (root == null) {
            List<List<Integer>> res =  new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> left = generate(root.left);
        List<List<Integer>> right = generate(root.right);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(root.val);

        for (List<Integer> leftIntegers : left) {
            for (List<Integer> rightIntegers : right) {
                merge(leftIntegers, rightIntegers, nums, res);
            }
        }

        return res;
    }

    private static void merge(List<Integer> left, List<Integer> right,
                                      List<Integer> nums, List<List<Integer>> res) {
        if (left.size() == 0 && right.size() == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }
        if (left.size() > 0) {
            // 先添加 left 的第一位
            int x = left.remove(0);
            nums.add(x);
            merge(left, right, nums, res);
            left.add(0, x);
            nums.remove(nums.size() - 1);
        }
        if (right.size() > 0) {
            // 再添加 right 的第一位
            int x = right.remove(0);
            nums.add(x);
            merge(left, right, nums, res);
            right.add(0, x);
            nums.remove(nums.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(4);
        root.left.right.right.left = new TreeNode(3);

//        root.right = new TreeNode(8);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(10);
        System.out.println(new Solution().BSTSequences(root));

//        List<Integer> nums1 = new ArrayList<>();
//        nums1.add(3);
//        nums1.add(1);
//
//        List<Integer> nums2 = new ArrayList<>();
//        nums2.add(5);
//        nums2.add(7);
//
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> tmp = new ArrayList<>();
//        tmp.add(4);
//        merge(nums1, nums2, tmp, res);
//        System.out.println(res);
    }
}
