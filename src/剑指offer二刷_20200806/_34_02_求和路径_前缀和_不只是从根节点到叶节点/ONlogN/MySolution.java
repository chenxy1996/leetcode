package 剑指offer二刷_20200806._34_02_求和路径_不只是从根节点到叶节点.ONlogN;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    List<Integer> bag = new ArrayList<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return search(root, 0, sum);
    }

    private int search(TreeNode node, int level, int sum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (level == bag.size()) {
            bag.add(node.val);
        } else {
            bag.set(level, node.val);
        }
        int nowSum = 0;
        for(int i = level; i >= 0; i--) {
            nowSum += bag.get(i);
            if (nowSum == sum) {
                count++;
            }
        }
        return count + search(node.left, level + 1, sum) + search(node.right, level + 1, sum);
    }
}
