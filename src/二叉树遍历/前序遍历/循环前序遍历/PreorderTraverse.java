package 二叉树遍历.前序遍历.循环前序遍历;

import 面试金典._04_树和图问题.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreorderTraverse {
    public static void traverse(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                System.out.println(root.val);
                deque.addLast(root);
                root = root.left;
            }
            TreeNode top = deque.removeLast();
            root = top.right;
        }
    }

    public static void traverse1(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            if (root != null) {
                System.out.println(root.val);
                deque.addLast(root);
                root = root.left;
            } else {
                TreeNode top = deque.removeLast();
                root = top.right;
            }
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);

        traverse1(root);
    }
}
