package 题目._43_困难_接雨水;

/**
 * 初见写的
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int valI = height[i];
            int valJ = height[j];
            int temp = 0;
            int delta = 0;
            if (valI <= valJ) {
                // 移动左边的指针
                int p1 = i;
                while (p1 <= j && (delta = valI - height[p1]) >= 0) {
                    temp += delta;
                    p1++;
                }
                if (p1 > i && p1 <= j + 1) {
                    ans += temp;
                    i = p1;
                }
            } else {
                // 移动右边的指针
                int p2 = j;
                while (p2 >= i && (delta = valJ - height[p2]) >= 0) {
                    temp += delta;
                    p2--;
                }
                if (p2 < j && p2 >= i) {
                    ans += temp;
                    j = p2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {};
        System.out.println(new Solution().trap(height));
    }
}
