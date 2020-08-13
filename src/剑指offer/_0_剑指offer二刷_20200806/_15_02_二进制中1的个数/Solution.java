package 剑指offer._0_剑指offer二刷_20200806._15_02_二进制中1的个数;

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
