package 剑指offer._0_剑指offer二刷_20200806._06_从尾到头打印链表;

import 剑指offer.ListNode;

public class OptimalSolution {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int[] ans = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            ans[i] = head.val;
            head = head.next;
        }
        return ans;
    }
}
