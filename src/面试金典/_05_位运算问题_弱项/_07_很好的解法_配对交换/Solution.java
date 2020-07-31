package 面试金典._05_位运算问题_弱项._07_很好的解法_配对交换;

public class Solution {
    public static int exchangeBits(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int low = num & 0b11;
            num = num >>> 1;
            num = num >>> 1;
            if (low == 1) {
                sb.insert(0, "10");
            } else if (low == 2) {
                sb.insert(0, "01");
            } else if (low == 3) {
                sb.insert(0, "11");
            } else {
                sb.insert(0, "00");
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(exchangeBits(2));
    }
}
