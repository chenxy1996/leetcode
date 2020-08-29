package 剑指offer二刷_20200806._33_03_层序遍历变种_二叉搜索树序列.利用层序遍历类似的方法;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 面试金典 04.09
 * 困难
 *
 *
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<TreeNode> bag = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            return ans;
        }
        bag.add(root);
        generate(bag, new ArrayList<>());
        return ans;
    }

    private void generate(List<TreeNode> bag, List<Integer> arrangement) {
        if (bag.isEmpty()) {
            ans.add(List.copyOf(arrangement));
            return;
        }
        for(int i = 0; i < bag.size(); i++) {
            TreeNode node = bag.remove(i);
            arrangement.add(node.val);
            int cnt = 0;
            if(node.left != null) {
                bag.add(node.left);
                cnt++;
            }
            if(node.right != null) {
                bag.add(node.right);
                cnt++;
            }
            generate(bag, arrangement);
            arrangement.remove(arrangement.size() - 1);
            bag.add(i, node);
            while (cnt > 0) {
                bag.remove(bag.size() - 1);
                cnt--;
            }
        }
    }

    public static void main(String[] args) {

    }
}
