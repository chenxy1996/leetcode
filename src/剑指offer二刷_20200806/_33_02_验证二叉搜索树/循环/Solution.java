package 剑指offer二刷_20200806._33_02_验证二叉搜索树.循环;

import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long min = Long.MIN_VALUE;
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.addLast(p);
                p = p.left;
            } else {
                TreeNode top = stack.removeLast();
                if (top.val <= min) {
                    return false;
                }
                min = top.val;
                p = top.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(isValidBST(root));
    }
}
