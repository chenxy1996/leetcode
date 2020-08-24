package 剑指offer二刷_20200806._38_07_比特位计数.更好的解法;

public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}
