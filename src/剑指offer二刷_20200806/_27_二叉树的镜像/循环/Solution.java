package 剑指offer二刷_20200806._27_二叉树的镜像.循环;

import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 相当于层级遍历
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(p);
        while (!stack.isEmpty()) {
            TreeNode top = stack.removeLast();
            TreeNode tmp = top.left;
            top.left = top.right;
            top.right = tmp;
            if (top.left != null) {
                stack.addLast(top.left);
            }
            if (top.right != null) {
                stack.addLast(top.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.addLast(null);
        Stack<TreeNode> stack = new Stack<>();
        stack.add(null);
    }
}
