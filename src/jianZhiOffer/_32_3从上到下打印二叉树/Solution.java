<<<<<<< HEAD
package jianZhiOffer._32_3从上到下打印二叉树;

import jianZhiOffer.TreeNode;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        boolean fromLeft = true;

        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<>();

            for (TreeNode treeNode : stack) {
                if (fromLeft) {
                    line.add(treeNode.val);
                } else {
                    line.add(0, treeNode.val);
                }


                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }

            res.add(line);
            fromLeft = !fromLeft;
            stack = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }
}
=======
package jianZhiOffer._32_3从上到下打印二叉树;

import jianZhiOffer.TreeNode;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        boolean fromLeft = true;

        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<>();

            for (TreeNode treeNode : stack) {
                if (fromLeft) {
                    line.add(treeNode.val);
                } else {
                    line.add(0, treeNode.val);
                }


                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }

            res.add(line);
            fromLeft = !fromLeft;
            stack = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
