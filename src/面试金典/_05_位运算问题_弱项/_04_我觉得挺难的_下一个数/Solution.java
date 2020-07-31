package 面试金典._05_位运算问题_弱项._04_我觉得挺难的_下一个数;

import java.util.Arrays;

/**
 * 第一次写没有写出来，这道题和之前那个 nextPermutation 差不多，但还是没有想出来
 *
 * 比 num 大的数：从右往左，找到第一个 01 位置，然后把 01 转为 10，右侧剩下的 1 移到右侧的低位，右侧剩下的位清0。
 * 比 num 小的数：从右往左，找到第一个 10 位置，然后把 10 转为 01，右侧剩下的 1 移到右侧的高位，右侧剩下的位置0。
 *
 */
public class Solution {
    public int[] findClosedNumbers(int num) { // num 为正整数
        int[] ans = new int[] {-1, -1};
        int num1 = num;
        int cnt = 0;
        int oneCnt = 0;
        int preBit = 0;
        int bit;

        while (num1 != 0) {
            bit = num1 & 1;
            num1 = num1 >>> 1;
            cnt++;
            if (bit == 1) {
                oneCnt++;
            } else { // bit == 0
                if (cnt > 1 && preBit == 1) { // 说明 bit 不是第一位上的值
//                    int a = num1 << cnt;
//                    int b = 1 << (cnt - 1);
//                    int c = oneCnt == 1 ? 0 : -1 >>>  (32 - (oneCnt - 1));
//                    ans[0] = a | b | c;
                    ans[0] = (num1 << cnt) | (1 << (cnt - 1)) | (oneCnt == 1 ? 0 : -1 >>>  (32 - (oneCnt - 1)));
                    break;
                }
            }
            preBit = bit;
        }

        // num 为 0b111, 0b1 这种类型
        if (ans[0] == -1 && cnt != 31) {
//            int b = oneCnt == 1 ? 0 : -1 >>>  (32 - (oneCnt - 1));
//            ans[0] = (1 << cnt) | b;
            ans[0] = (1 << cnt) | (oneCnt == 1 ? 0 : -1 >>>  (32 - (oneCnt - 1)));
        }

        oneCnt = 0;
        cnt = 0;

        while (num != 0) {
            bit = num & 1;
            num = num >>> 1;
            cnt++;
            if (bit == 1) {
                oneCnt++;
                if (cnt > 1 && preBit == 0) {
//                    int a = num << cnt;
                    int b = -1 >>> (32 - (oneCnt));
//                    int c = b << (cnt - oneCnt - 1);
//                    ans[1] = a | c;
                    ans[1] = (num << cnt) | b << (cnt - oneCnt - 1);
                    break;
                }
            }
            preBit = bit;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int num = 211;
        Solution solution = new Solution();
//        int num = Integer.MAX_VALUE - 11;
        int num = 3;
//        int num = 1837591841;
        System.out.println(Integer.toBinaryString(num));
//        System.out.println(Integer.toBinaryString(1837591825));
//        System.out.println(Integer.toBinaryString(1837591832));
        int[] ans = solution.findClosedNumbers(num);
        System.out.println(Arrays.toString(ans));
        System.out.println(Integer.toBinaryString(ans[0]));
        System.out.println(Integer.toBinaryString(ans[1]));
    }
}
