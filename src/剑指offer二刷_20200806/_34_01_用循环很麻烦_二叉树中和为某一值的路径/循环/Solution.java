package 剑指offer二刷_20200806._34_01_用循环很麻烦_二叉树中和为某一值的路径.循环;

import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> marks = new ArrayDeque<>();
        TreeNode p  = root;
        int nowSum = 0;
        while (p != null || !stack.isEmpty()) {
            if (p == null) {
                int mark = marks.peekLast();
                TreeNode top = stack.peekLast();
                if (mark == 1) {
                    marks.removeLast();
                    marks.addLast(0);
                    p = top.right;
                } else {
                    if (nowSum == sum && top.left == null && top.right == null) {
                        ans.add(new ArrayList<>(path));
                    }
                    stack.removeLast();
                    nowSum -= path.remove(path.size() - 1);
                    marks.removeLast();
                }
            } else {
                nowSum += p.val;
                path.add(p.val);
                stack.addLast(p);
                // 给每个节点做标记, 有右节点的做标记 1 , 否则为 0
                if (p.right != null) {
                    marks.add(1);
                } else {
                    marks.add(0);
                }
                p = p.left;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
//        root.left.left.left.right = new TreeNode(8);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution().pathSum(root, 22));
    }
}
