package 面试金典._05_位运算问题_弱项._07_很好的解法_配对交换;

public class OptimalSolution {
    // 0x55555555 = 0b0101_0101_0101_0101_0101_0101_0101_0101
    // 0xaaaaaaaa = 0b1010_1010_1010_1010_1010_1010_1010_1010
    public int exchangeBits(int num) {
        //奇数
        int odd = num & 0x55555555;
        //偶数
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >>> 1; // 无符号右移
        return odd | even;
    }
}
