package 剑指offer二刷_20200806._37_序列化二叉树;

import com.sun.source.tree.Tree;
import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        sb.append("[");
        sb.append(root.val);
        sb.append(",");
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode n = q.remove();
                sb.append(n.left == null ? null : n.left.val);
                sb.append(",");
                sb.append(n.right == null ? null : n.right.val);
                sb.append(",");
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.length() == 2) {
            return null;
        }
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode head = new TreeNode(Integer.valueOf(nodes[0]));
        queue.add(head);
        for(int i = 1; i < nodes.length;) {
            TreeNode n = queue.remove();
            TreeNode left = instantiate(nodes[i++]);
            if (left != null) {
                n.left = left;
                queue.add(left);
            }
            if (i < nodes.length) {
                TreeNode right = instantiate(nodes[i++]);
                if (right != null) {
                    n.right = right;
                    queue.add(right);
                }
            }
        }
        return head;
    }

    private TreeNode instantiate(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
        Solution solution = new Solution();
        solution.deserialize("[]");
//        String ss = solution.serialize(root);
//        System.out.println(ss);
//        TreeNode head = solution.deserialize(ss);
//        System.out.println("end");



    }
}
