package 剑指offer._65_位运算_不用加减乘除做加法;

public class OptimalSolution {
    public static int addRecursively(int a, int b) {
        if (b == 0) {
            return a;
        }
        return addRecursively(a ^ b, (a & b) << 1);
    }

    public static int addIteratively(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(addIteratively(2, 3));
    }
}
