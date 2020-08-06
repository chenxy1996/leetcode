package 剑指offer._64_求1到n之和;

// 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case
// 等关键字及条件判断语句（A?B:C）。
public class Solution {
    public static int sumNums(int n) {
        boolean res = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }
}
