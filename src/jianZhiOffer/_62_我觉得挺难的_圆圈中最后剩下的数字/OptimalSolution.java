package jianZhiOffer._62_我觉得挺难的_圆圈中最后剩下的数字;

/**
 * 约瑟夫环问题
 * 具体的讲解：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/huan-ge-jiao-du-ju-li-jie-jue-yue-se-fu-huan-by-as/
 */
public class OptimalSolution {
    public static int lastRemaining(int n, int m) {
        return findPos(n ,m);
    }

    private static int findPos(int n , int m) {
        // 当 n == 1, 也就是只剩下一个人的时候，直接返回该人的序号 0
        if (n == 1) {
            return 0;
        }
        // n 不为 1 , 也就是剩下不知一个人的时候
        int x = findPos(n - 1, m);
        return (m + x) % n;
    }

    // 迭代的方式
    public static int lastRemainingIterativeWay(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(lastRemainingIterativeWay(5, 3));
    }
}
