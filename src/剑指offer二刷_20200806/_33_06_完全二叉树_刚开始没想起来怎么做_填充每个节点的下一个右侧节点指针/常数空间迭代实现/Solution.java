package 剑指offer二刷_20200806._33_06_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.常数空间迭代实现;

import 剑指offer二刷_20200806._33_06_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.Node;

public class Solution {
    public static Node connect(Node root) {
        Node p = root;
        while (p != null) {
            Node dummy = new Node();
            Node ptr = dummy;
            while (p != null) {
                if (p.left != null) {
                    ptr.next = p.left;
                    ptr = ptr.next;
                }
                if (p.right != null) {
                    ptr.next = p.right;
                    ptr = ptr.next;
                }
                p = p.next;
            }
            p = dummy.next;
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
