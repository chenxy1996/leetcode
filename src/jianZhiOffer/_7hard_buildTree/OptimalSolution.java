package jianZhiOffer._7hard_buildTree;

// leetcode 运行时间最小的写法
// 反正我是没看懂
public class OptimalSolution {
    private int pre = 0;
    private int in = 0;

    /**
     * @help: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/comments/210826
     * @time: 1ms 100.00%
     * @mem: 39.8MB 58.64%
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int val = preorder[pre++];
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, inorder, val);
        root.right = buildTree(preorder, inorder, stop);
        return root;
    }
}
