package 剑指offer二刷_20200806._33_06_完全二叉树_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.递归实现_难;


import 剑指offer二刷_20200806._33_06_完全二叉树_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.Node;

/**
 * 每个 node 左子树的 next , 就是 node 的右子树
 * 每个 node 右子树的 next, 就是 node next 的 左子树
 */
public class Solution {
    public Node connect(Node root) {
        link(root);
        return root;
    }

    private void link(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            node.left.next = node.right;
            if (node.next != null) {
                node.right.next = node.next.left;
            }
        }
        link(node.left);
        link(node.right);
    }
}
