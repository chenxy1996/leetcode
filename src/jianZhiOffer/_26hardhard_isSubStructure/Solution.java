package jianZhiOffer._26hardhard_isSubStructure;

public class Solution {
     static public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
      public boolean isSubStructureTree(TreeNode A, TreeNode B) {
         return inOrderTraverseAndCompare(A, B);
      }

      private static boolean inOrderTraverseAndCompare(TreeNode a, TreeNode b) {
         if (a == null) {
             return false;
         }

         if (b == null) {
             return false;
         }

         if (a.val == b.val) {
             if (isSame(a, b)) {
                 return true;
             }
         }

         return inOrderTraverseAndCompare(a.left, b) || inOrderTraverseAndCompare(a.right, b);
      }

      private static boolean isSame(TreeNode a, TreeNode b) {
         if (a != null && b != null && a.val == b.val) {
             return isSame(a.left, b.left) && isSame(a.right, b.right);
         } else if (b == null) {
             return true;
         } else {
             return false;
         }
      }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        a.left = new TreeNode(12);
        a.right = new TreeNode(3);
        a.right.left = new TreeNode(11);
        a.left.left = new TreeNode(6);
        a.left.right = new TreeNode(8);

        TreeNode b = new TreeNode(10);
        b.left = new TreeNode(12);
        b.left.left = new TreeNode(6);
        b.left.right = new TreeNode(8);

        System.out.println(isSame(a, b));
        Solution solution = new Solution();
        System.out.println(solution.isSubStructureTree(a, b));
    }
}
