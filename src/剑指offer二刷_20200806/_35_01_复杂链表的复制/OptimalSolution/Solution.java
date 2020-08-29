package 剑指offer二刷_20200806._35_01_复杂链表的复制.OptimalSolution;

public class Solution {
    private static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // step1:
        // A -> B -> C -> D
        // A -> A' -> B -> B' -> C -> C' -> D -> D'
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }

        // step2:
        // 开始初始化新 Node 的 random 属性
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // step3: 分开链表
        Node newHead = head.next;
        cur = head;
        while (cur != null) {
            Node temp = cur.next.next;
            if (temp != null) {
                cur.next.next = temp.next;
            } else {
                cur.next.next = null;
            }
            cur.next = temp;
            cur = temp;
        }

        return newHead;
    }
}
