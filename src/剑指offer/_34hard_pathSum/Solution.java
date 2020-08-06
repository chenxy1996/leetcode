package 剑指offer._34hard_pathSum;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root != null)
            reccur(root, 0, sum, new ArrayList<>(), ret);
        return ret;
    }

    private void reccur(TreeNode curr, int nowSum, int sum, List<Integer> nowList, List<List<Integer>> ret) {
        int currSum = nowSum + curr.val;

        // 如果为叶节点
        if (curr.left == null && curr.right == null) {
            // 叶节点，且总共相加为 sum
            if (currSum == sum) {
                nowList.add(curr.val);
                ret.add(new ArrayList<>(nowList));

                // 回溯前删除新加的
                nowList.remove(nowList.size() - 1);
            }
        } else {
            // 为根节点
            // 如果此时相加不超过sum , 继续递归
            nowList.add(curr.val);

            if (curr.left != null) {
                reccur(curr.left, currSum, sum, nowList, ret);
            }

            if (curr.right != null) {
                reccur(curr.right, currSum, sum, nowList, ret);
            }

            // 回溯前删除新加的
            nowList.remove(nowList.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(18);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.left = new TreeNode(-8);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.pathSum(root, 30));

//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
    }
}
