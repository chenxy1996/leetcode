package 剑指offer._0_剑指offer二刷_20200806._34_02_求和路径_不只是从根节点到叶节点.前缀和;

import 剑指offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        map.put(0, 1);
        search(root, sum, 0);
        return count;
    }

    private void search(TreeNode node, int sum, int nowSum) {
        if (node == null) {
            return;
        }
        nowSum = nowSum + node.val;
        int delta = nowSum - sum;
        count += map.getOrDefault(delta, 0);
        map.put(nowSum, map.getOrDefault(nowSum, 0) + 1);
        search(node.left, sum, nowSum);
        search(node.right, sum, nowSum);
        map.put(nowSum, map.get(nowSum) - 1);
    }
}
