package 面试金典._04_树和图问题._12_我觉得挺难的_求和路径;

import 面试金典._04_树和图问题.TreeNode;

import java.util.Map;

/**
 * 这道题和 437 题是一样的
 *
 * 最容易想到的办法：以每个节点为根节点，都算一边路径和为 sum 的有几条，然后加起来
 * 但是这样子的解法存在大量重复计算，非常耗时间，耗空间。
 */
public class Solution {
    public static int pathSum(TreeNode root, int sum) {
        return traverse(root, sum, 0);
    }

    private static int traverse(TreeNode node, int sum, int added) {
        if (node == null) {
            return 0;
        }
        int val = node.val;
        int res = 0;
        if (added + val == sum) {
            res += 1;
        }
        res += traverse(node.left, sum, added + val);
        res += traverse(node.right, sum, added + val);
        res += traverse(node.left, sum, 0);
        res += traverse(node.right, sum, 0);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }

    private int traverse(TreeNode node , int sum, Map<Integer, Integer> map, int added) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        int val = node.val;
        added += val;
        int pre = added - sum;
        res += map.getOrDefault(pre, 0);
        map.put(added + val, map.getOrDefault(added, 0) + 1);

        res += traverse(node.left, sum, map, added);
        res += traverse(node.right, sum, map, added);

        map.put(added, map.get(added) - 1);
        return res;
    }
}
