package 剑指offer二刷_20200806._33_06_完全二叉树_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.常数空间迭代实现;

import 剑指offer二刷_20200806._33_06_完全二叉树_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.Node;

public class Solution {
    public static Node connect(Node root) {
        Node p = root;
        while (p != null) {
            Node leftMost = p;
            while (p != null && p.left != null) {
                p.left.next = p.right;
                if (p.next != null) {
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            p = leftMost.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        connect(root);
    }
}
