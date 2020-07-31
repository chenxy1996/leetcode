package 面试金典._04_树和图问题._03_特定深度节点链表;

import 面试金典._02_链表问题.ListNode;
import 面试金典._04_树和图问题.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    // 二叉树的层序遍历
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(tree);
        while (!deque.isEmpty()) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
                ListNode listNode = new ListNode(treeNode.val);
                curr.next = listNode;
                curr = curr.next;
            }
            list.add(dummy.next);
        }
        return list.toArray(ListNode[]::new);
    }
}
