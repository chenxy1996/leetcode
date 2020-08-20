package dp._95_不同的二叉搜索树;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int s, int e) {
        List<TreeNode> ans = new ArrayList<>();
        if (s > e) {
            ans.add(null);
        } else {
            for(int i = s; i <= e; i++) {
                List<TreeNode> left = generate(s, i - 1);
                List<TreeNode> right = generate(i + 1, e);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        ans.add(node);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> res = solution.generateTrees(3);
        for (TreeNode re : res) {
            System.out.println(re);
        }
    }
}
