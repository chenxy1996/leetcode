package 二叉树遍历.层序遍历.递归层序遍历;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归方式，先切片在合并
 */
public class LevelOrderTraverse {
    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        List<List<Integer>> ans = new ArrayList<>();
        traverse(0, root, ans);
        for (List<Integer> an : ans) {
            for (int integer : an) {
                System.out.println(integer);
            }
        }
    }

    private static void traverse(int level, TreeNode node, List<List<Integer>> bag) {
        if (node == null) {
            return;
        }
        if (bag.size() == level) {
            bag.add(new ArrayList<>());
        }
        bag.get(level).add(node.val);
        traverse(level + 1, node.left, bag);
        traverse(level + 1, node.right, bag);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        traverse(root);
    }
}
