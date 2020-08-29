package 滑动窗口和字符串._1004_最大连续1的个数_3;

public class Solution {
    public static int longestOnes(int[] A, int K) {
        int l = 0;
        int r = 0;
        int oneCount = 0;
        while (r < A.length) {
            int p = A[r];
            if (p == 1) {
                oneCount++;
            }
            if (oneCount + K < r - l + 1) {
                if (A[l] == 1) {
                    oneCount--;
                }
                l++;
            }
            r++;
        }
        return r - l;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,1,0,0,0,1,1,1,0,1};
        int k = 1;
        System.out.println(longestOnes(nums, k));
    }
}
