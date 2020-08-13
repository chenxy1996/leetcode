package 二叉树遍历.后序遍历.循环后序遍历;

import 面试金典._04_树和图问题.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostorderTraverse {
    public static void traverse(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> marks = new ArrayList<>();
        while (root != null || !deque.isEmpty()) {
            if (root != null) {
                deque.addLast(root);
                marks.add(1);
                root = root.right;
            } else {
                int mark = marks.get(marks.size() - 1);
                if (mark == 1) {
                    TreeNode top = deque.peekLast();
                    root = top.left;
                    marks.set(marks.size() - 1, 0);
                } else {
                    TreeNode top = deque.removeLast();
                    marks.remove(marks.size() - 1);
                    System.out.println(top.val);
                }
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

        traverse(root);
    }
}
