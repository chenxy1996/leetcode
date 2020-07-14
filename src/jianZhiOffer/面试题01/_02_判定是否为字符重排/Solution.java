package jianZhiOffer.面试题01._02_判定是否为字符重排;

// 第一种排序就可以了，但是要首先排序，然后再比较
// 第二种利用二叉堆（优先队列），每次都比较剩余字符中最大值的字符，
// 如果不相等就直接返回 false
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int size = s1.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        construct(chars1);
        construct(chars2);
        for (int i = 0; i < size; i++) {
            if (chars1[0] != chars2[0]) {
                return false;
            }
            swap(chars1, 0, size - i - 1);
            swap(chars2, 0, size - i - 1);
            moveFromTop(chars1, 0, size - i - 1);
            moveFromTop(chars2, 0, size - i - 1);
        }
        return true;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void construct(char[] chars) {
        for (int i = chars.length / 2 - 1; i >= 0; i--) {
            moveFromTop(chars, i, chars.length);
        }
    }

    private static void moveFromTop(char[] chars, int p, int end) {
        char temp = chars[p];
        for (int k = 2 * p + 1; k < end; k = 2 * k + 1) {
            if (k + 1 < end && chars[k + 1] > chars[k]) {
                k = k + 1;
            }
            if (temp < chars[k]) {
                chars[p] = chars[k];
                p = k;
            } else {
                break;
            }
        }
        chars[p] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "";
        String s2 = "";
        System.out.println(solution.CheckPermutation(s1, s2));
    }
}
