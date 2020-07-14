package jianZhiOffer.面试题01._01_判定字符是否唯一;

// 难点不使用额外的数据结构
// 此题目没有明说，但是其实字符串全部由 a -> z 组成
// 可以用一个 int 类型数字来做哈希表
public class Solution {
    public boolean isUnique(String astr) {
        int map = 0;
        for (int i = 0; i < astr.length(); i++) {
            int p = astr.charAt(i) - 'a';
            if (isOne(map, p)) {
                return false;
            }
            map = setOne(map, p);
        }
        return true;
    }

    public boolean isOne(int num, int k) {
        return ((num >>> k) & 1) == 1;
    }

    public int setOne(int num, int k) {
        num |= 1 << k;
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "letcod";
        System.out.println(solution.isUnique(s));
    }
}
