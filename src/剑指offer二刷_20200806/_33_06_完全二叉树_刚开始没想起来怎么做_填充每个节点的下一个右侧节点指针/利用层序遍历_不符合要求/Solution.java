package 剑指offer二刷_20200806._33_06_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.利用层序遍历_不符合要求;


import 剑指offer二刷_20200806._33_06_刚开始没想起来怎么做_填充每个节点的下一个右侧节点指针.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 不满足题目要求的常数额外空间
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            for(int i = 0; i < size; i++) {
                Node front = deque.removeFirst();
                if (front.left != null) {
                    deque.addLast(front.left);
                    deque.addLast(front.right);
                }
                if (i == 0) {
                    pre = front;
                } else {
                    pre.next = front;
                    pre = pre.next;
                }
            }
        }
        return root;
    }
}
