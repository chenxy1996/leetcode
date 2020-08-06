package 剑指offer._37hard_序列化二叉树;

import 剑指offer.TreeNode;

import java.util.*;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        // 最简单的二叉树层序遍历
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.remove(0);
            if (top != null) {
                sb.append(top.val + ",");
                stack.add(top.left);
                stack.add(top.right);
            } else {
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        data = data.substring(1, data.length() - 1);
        String[] strings = data.split(",");

        if (strings.length == 1 && strings[0].length() == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < strings.length) {
            TreeNode curr = queue.poll();
            if (!strings[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(strings[i]));
                curr.left = left;
                queue.add(left);

            }
            i++;
            if (i < strings.length && !strings[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(strings[i]));
                curr.right = right;
                queue.add(right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//
        Solution solution = new Solution();
        System.out.println(solution.serialize(null));

//        String data = "[1,2,3,null,null,4,5,null,null,null,null]";
        String data = "[]";
        System.out.println(solution.deserialize(data));
    }
}
