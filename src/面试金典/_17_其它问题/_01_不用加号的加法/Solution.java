package 面试金典._17_其它问题._01_不用加号的加法;

public class Solution {
    public static int add(int a, int b) {
        while (a != 0) {
            int temp = (a & b) << 1;
            b = a ^ b;
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(add(-1, 2));
    }
}
