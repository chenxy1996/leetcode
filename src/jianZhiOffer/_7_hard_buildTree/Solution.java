package jianZhiOffer._7_hard_buildTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTreeNode(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        return build(preorder, 0, length - 1, inorder, 0, length - 1);
    }

    private TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        int currNumber = preorder[s1];
        TreeNode currNode = new TreeNode(currNumber);
        if (s1 == e1) {
            return currNode;
        }

        int i = s2;
        for (; i <= e2; i++) {
            if (currNumber == inorder[i]) {
                break;
            }
        }

        int offset = i - s2;

        if (i - 1 >= s2) {
            currNode.left = build(preorder, s1 + 1, s1 + offset, inorder, s2, i - 1);
        }

        if (i + 1 <= e2) {
            currNode.right = build(preorder, s1 + offset + 1, e1, inorder, i + 1, e2);
        }

        return currNode;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3};
        int[] in = {2, 3, 1};
        TreeNode root = new Solution().buildTreeNode(pre, in);
    }
}
