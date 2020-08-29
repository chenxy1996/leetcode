package 剑指offer二刷_20200806._25_04_分隔链表2;

import 剑指offer.ListNode;

public class Solution {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[0];
        }
        if (k == 1) {
            return new ListNode[] {root};
        }
        int cnt = 0;
        ListNode p = root;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        int m = cnt / k;
        int n = cnt % k;
        p = root;
        ListNode[] ans = new ListNode[k];
        for(int i = 0; i < k && p != null; i++) {
            ListNode head = p;
            int move = i < n ? m : m - 1;;
            for(int j = 0; j < move; j++) {
                p = p.next;
            }
            if (p != null) {
                ListNode next = p.next;
                p.next = null;
                p = next;
            }
            ans[i] = head;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for(int i = 2; i <= 9; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        splitListToParts(head, 4);
    }
}
