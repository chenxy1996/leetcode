package 剑指offer二刷_20200806._35_复杂链表的复制;

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
        head = copy(head);
        return split(head);
    }

    private Node copy(Node head) {
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            newNode.random = p.random;
            p.next = newNode;
            p = p.next.next;
        }
        p = head.next;
        while (p != null) {
            if (p.random != null) {
                p.random = p.random.next;
            }
            if (p.next == null) {
                break;
            }
            p = p.next.next;
        }
        return head;
    }

    private Node split(Node head) {
        Node newHead = head.next;
        Node p = head;
        while (p != null) {
            Node tmp = p.next.next;
            if (tmp != null) {
                p.next.next = tmp.next;
            }
            p.next = tmp;
            p = p.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node _7Node = new Node(7);
        Node _13Node = new Node(13);
        Node _11Node = new Node(11);

        _7Node.random = null;
        _7Node.next = _13Node;
        _13Node.random = _7Node;
        _13Node.next = _11Node;
        _11Node.random = _13Node;

        Node newHead = new Solution().copyRandomList(_7Node);
    }
}
