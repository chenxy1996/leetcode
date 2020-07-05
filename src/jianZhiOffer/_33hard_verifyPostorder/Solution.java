package jianZhiOffer._33hard_verifyPostorder;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(0, postorder.length - 1, postorder);
    }

    private boolean recur(int i, int j, int[] postorder) {
        if (i >= j) {
            return true;
        }

        int p = i;

        while (postorder[p] < postorder[j]) {
            p++;
        }

        int m = p;

        while (postorder[p] > postorder[j]) {
            p++;
        }

        return p == j && recur(i, m - 1, postorder) && recur(m, j - 1, postorder);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 8, 6, 12, 16, 14, 10};

        Solution s = new Solution();
        System.out.println(s.verifyPostorder(nums));
    }
}
