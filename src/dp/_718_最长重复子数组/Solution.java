package dp._718_最长重复子数组;

/**
 * 和 1143 题很像
 */
public class Solution {
    public static int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int ans = 0;
        int[] dp = new int[len2 + 1];
        for(int i = 1; i <= len1; i++) {
            for (int j = len2; j >= 1; j--) {
                dp[j] = A[i - 1] == B[j - 1] ? dp[j - 1] + 1 : 0;
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,0,0,1,1};
        int[] nums2 = {1,0,0,0,1};
        System.out.println(findLength(nums1, nums2));
    }
}
