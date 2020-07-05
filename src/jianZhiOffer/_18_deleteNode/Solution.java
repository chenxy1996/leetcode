package jianZhiOffer._18_deleteNode;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dump = new ListNode(0);
        dump.next = head;

        ListNode left, right;
        left = dump;
        right = head;

        while (right != null) {
            if (right.val == val) {
                left.next = right.next;
                break;
            }

            left = left.next;
            right = right.next;
        }

        return dump.next;
    }
}
