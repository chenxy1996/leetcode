package 剑指offer._0_剑指offer二刷_20200806._10_03_三步问题;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实
 * 现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        int a = 1;
        int b = 2;
        int c = 4;

        int module = 1000000007;

        for (int i = 4; i <= n; i++) {
            int tmp = ((a + b) % module + c) % module;
            a = b;
            b = c;
            c = tmp;
        }

        return c;
    }
}
