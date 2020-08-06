package 剑指offer._35_复杂链表的复制;

import 剑指offer.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 这个使用了一个 map
    public Node copyRandomList(Node head) {
        // 辅助 Node
        Node dump = new Node(0);
        Node newHead = dump;

        Map<Node, Node> map = new HashMap<>();

        while (head != null) {
            Node newNode;

            if ((newNode = map.get(head)) == null) {
                newNode = new Node(head.val);
                map.put(head, newNode);
            }

            if (head.random != null) {
                Node random;
                if ((random = map.get(head.random)) == null) {
                    random = new Node(head.random.val);
                    map.put(head.random, random);
                }
                newNode.random = random;
            }

            newHead.next = newNode;
            newHead = newHead.next;

            head = head.next;
        }

        return dump.next;
    }

    // 不适用额外辅助 map
    // 利用这种方法
    // A -> B -> C -> D
    // A -> A' -> B -> B' -> C -> C' -> D -> D'
    public Node copyRandomList1(Node head) {
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

    public static void main(String[] args) {
        // 初始化案例
        Node head = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = head;
        node3.random = node5;
        node4.random = node3;
        node5.random = head;

        Solution solution = new Solution();
        Node newHead = solution.copyRandomList1(head);
        while (newHead != null) {
            System.out.println("---");
            System.out.println(newHead.val);
            System.out.println("+++" + (head == newHead));
            if (newHead.random != null) {
                System.out.println(newHead.random.val);
                System.out.println("+++" + (head.random == newHead.random));
            } else {
                System.out.println("null");
            }
            newHead = newHead.next;
            head = head.next;
        }
    }
}
