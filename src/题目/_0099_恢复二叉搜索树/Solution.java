package 题目._0099_恢复二叉搜索树;

import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private TreeNode[] nodes = new TreeNode[2];

    public void recoverTree(TreeNode root) {
        search(root);
        int temp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = temp;
    }

    private void search(TreeNode root) {
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.addLast(p);
                p = p.left;
            } else {
                TreeNode last = stack.removeLast();
                if (prev != null && last.val < prev.val) {
                    nodes[1] = last;
                    if (nodes[0] == null) {
                        nodes[0] = prev;
                    } else {
                        break;
                    }
                }
                prev = last;
                p = last.right;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        solution.recoverTree(root);
    }
}
