package 剑指offer二刷_20200806._34_01_用循环很麻烦_二叉树中和为某一值的路径.递归;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return ans;
        }
        search(root, 0, sum, new ArrayList<>());
        return ans;
    }

    private void search(TreeNode node, int nowSum, int sum, List<Integer> bag) {
        bag.add(node.val);
        if (node.left == null && node.right == null && nowSum + node.val == sum) {
            ans.add(new ArrayList<>(bag));
            bag.remove(bag.size() - 1);
            return;
        }
        if (node.left != null) {
            search(node.left, nowSum + node.val, sum, bag);
        }
        if (node.right != null) {
            search(node.right, nowSum + node.val, sum, bag);
        }
        bag.remove(bag.size() - 1);
    }
}
