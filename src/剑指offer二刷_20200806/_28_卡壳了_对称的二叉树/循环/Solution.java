package 剑指offer._0_剑指offer二刷_20200806._28_卡壳了_对称的二叉树.循环;

import 剑指offer.ListNode;
import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<TreeNode> bag = new ArrayList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = deque.removeFirst();
                bag.add(top.left);
                bag.add(top.right);
                if (top.left != null) {
                    deque.addLast(top.left);
                }
                if (top.right != null) {
                    deque.addLast(top.right);
                }
            }
            size = bag.size();
            if ((size & 1) == 1) {
                return false;
            } else {
                int l = 0;
                int r = size - 1;
                while (l < r) {
                    TreeNode left = bag.get(l);
                    TreeNode right = bag.get(r);
                    if (left == null && right == null) {
                        l++;
                        r--;
                        continue;
                    }
                    if (left != null && right != null && left.val == right.val) {
                        l++;
                        r--;
                        continue;
                    }
                    return false;
                }
                bag.clear();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(isSymmetric(root));
    }
}
