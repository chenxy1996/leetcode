package jianZhiOffer._32_2从上到下打印二叉树;

import jianZhiOffer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 利用迭代的方法
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        List<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        while (stack.size() > 0) {
            List<TreeNode> temp = new LinkedList<>();
            List<Integer> list = new ArrayList<>();

            stack.forEach(treeNode -> {
                list.add(treeNode.val);

                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            });

            res.add(list);
            stack = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }
}
