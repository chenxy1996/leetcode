package 剑指offer._0_剑指offer二刷_20200806._32_01_从上到下打印二叉树;

import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> bag = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = deque.removeFirst();
                bag.add(front.val);
                if (front.left != null) {
                    deque.addLast(front.left);
                }
                if (front.right != null) {
                    deque.addLast(front.right);
                }
            }
        }
        int[] ans = new int[bag.size()];
        int p = 0;
        for (int num : bag) {
            ans[p++] = num;
        }
        return ans;
    }
}
