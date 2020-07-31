package 面试金典._04_树和图问题._12_我觉得挺难的_求和路径;

import 面试金典._04_树和图问题.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 用一个 map 记录前缀和
 */
public class OptimalSolution {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return traverse(root, sum, map, 0);
    }

    private int traverse(TreeNode node , int sum, Map<Integer, Integer> map, int added) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        int val = node.val;
        int pre = added + val - sum;
        res += map.getOrDefault(pre, 0);
        map.put(added + val, map.getOrDefault(added + val, 0) + 1);
        res += traverse(node.left, sum, map, added + val);
        res += traverse(node.right, sum, map, added + val);

        map.put(added + val, map.get(added + val) - 1);
        return res;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        System.out.println(new OptimalSolution().pathSum(root, 0));
    }
}
