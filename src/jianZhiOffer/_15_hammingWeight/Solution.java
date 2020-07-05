package jianZhiOffer._15_hammingWeight;

public class Solution {
    public int hammingWeight(int n) {
        int num = 0;

        while (n != 0) {
            num++;
            n &= n - 1;
        }

        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(3));
    }
}
