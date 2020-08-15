package 剑指offer._0_剑指offer二刷_20200806._15_03_是否为2的整数次方;

public class Solution {
    public static boolean isPowOf2(int n) {
        return n == 0 ? false : ((n & (n - 1)) == 0 ? true : false);
    }

    public static void main(String[] args) {
        System.out.println(isPowOf2(0));
        System.out.println(isPowOf2(2));
        System.out.println(isPowOf2(1023));
        System.out.println(isPowOf2(1024));
    }
}
