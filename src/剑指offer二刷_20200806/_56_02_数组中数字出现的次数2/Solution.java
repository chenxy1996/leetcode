package 剑指offer二刷_20200806._56_02_数组中数字出现的次数2;

public class Solution {
    public static int singleNumber(int[] nums) {
        int[] map = new int[32];
        for(int e : nums) {
            for(int i = 0; i < 32; i++) {
                if ((e & 1) == 1) {
                    map[i] += 1;
                }
                e = e >>> 1;
            }
        }
        int weight = 1;
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            if (map[i] % 3 != 0) {
                ans += weight;
            }
            weight = weight << 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {9,2,7,9,7,9,7};
        System.out.println(singleNumber(nums));
    }
}
