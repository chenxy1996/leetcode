package 剑指offer二刷_20200806._32_02_从上倒下打印二叉树2;

import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> bag = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode top = deque.removeFirst();
                bag.add(top.val);
                if (top.left != null) {
                    deque.addLast(top.left);
                }
                if (top.right != null) {
                    deque.addLast(top.right);
                }
            }
            ans.add(bag);
        }
        return ans;
    }
}
