package 剑指offer._6_reversePrint;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) { val = x; }
}

public class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }

        int[] ret = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }
}
