package 面试金典._08_递归问题._01_三步问题;

/**
 * 动态规划
 */
public class OptimalSolution {
    public int waysToStep(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) { // [1,1,1], [1,2], [2,1], [3]
            return 4;
        }
        int a = 1;
        int b = 2;
        int c = 4;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            int temp = ((b + c) % mod + a) % mod;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    public static void main(String[] args) {
        OptimalSolution solution =  new OptimalSolution();
        System.out.println(solution.waysToStep(61));
    }
}
