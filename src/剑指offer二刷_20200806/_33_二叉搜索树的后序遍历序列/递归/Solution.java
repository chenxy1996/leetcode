package 剑指offer._0_剑指offer二刷_20200806._33_二叉搜索树的后序遍历序列.递归;

/**
 * 后序按照 左右根 顺序
 * 二叉搜索的话一般考虑从根节点出发
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }
        int rootVal = postorder[r];
        int i = l;
        while (i < r) {
            if (postorder[i] > rootVal) {
                break;
            }
            i++;
        }
        int m = i;
        while (i < r) {
            if (postorder[i] < rootVal) {
                return false;
            }
            i++;
        }
        return verify(postorder, l, m - 1) && verify(postorder, m, r - 1);
    }

    public static void main(String[] args) {
        int[] postorder = {1,2,5,10,6,9,4,3};
        System.out.println(new Solution().verifyPostorder(postorder));
    }
}
