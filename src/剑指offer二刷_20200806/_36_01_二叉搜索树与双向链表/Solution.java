package 剑指offer二刷_20200806._36_01_二叉搜索树与双向链表;

import 剑指offer二刷_20200806._33_06_完全二叉树_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.Node;

/**
 */
public class Solution {
    private Node head;
    private Node prev;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        link(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void link(Node node) {
        if (node == null) {
            return;
        }
        link(node.left);
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
        }
        node.left = prev;
        prev = node;
        link(node.right);
    }
}
