package 剑指offer二刷_20200806._33_二叉搜索树的后序遍历序列.循环;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        int l = 0;
        int r = postorder.length - 1;
        if (l == r) {
            return true;
        }
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{l , r});
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] front = deque.removeFirst();
                l = front[0];
                r = front[1];
                if (l >= r) {
                    continue;
                }
                int rootVal = postorder[r];
                int k = l;
                while (k < r && postorder[k] < rootVal) {
                    k++;
                }
                int m = k;
                while (k < r) {
                    if (postorder[k] < rootVal) {
                        return false;
                    }
                    k++;
                }
                deque.addLast(new int[] {l, m - 1});
                deque.addLast(new int[] {m, r - 1});
            }
        }
        return true;
    }
}
