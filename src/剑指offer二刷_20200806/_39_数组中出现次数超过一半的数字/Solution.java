package 剑指offer二刷_20200806._39_数组中出现次数超过一半的数字;

public class Solution {
    public int majorityElement(int[] nums) {
        int ans = 0;
        int cnt = 0;
        for(int i : nums) {
            if (cnt == 0) {
                ans = i;
            }
            cnt += (i == ans) ? 1 : -1;
        }
        return ans;
    }
}
