package 面试金典._05_位运算问题_弱项._06_整数转换;

public class OptimalSolution {
    public int convertInteger(int A, int B) {
        int res = 0;
        int tmp = A ^ B;
        while (tmp != 0) {
            tmp = tmp & (tmp - 1);
            res++;
        }
        return res;
    }
}
