package 剑指offer二刷_20200806._06_从尾到头打印链表.递归方法;

import 剑指offer.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<Integer> nums = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        reversePrintHelper(head);
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            ans[i] = nums.get(i);
        }
        return ans;
    }

    public void reversePrintHelper(ListNode node) {
        if (node == null) {
            return;
        }
        reversePrintHelper(node.next);
        nums.add(node.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        int[] ans = solution.reversePrint(head);
        System.out.println(Arrays.toString(ans));
    }
}
