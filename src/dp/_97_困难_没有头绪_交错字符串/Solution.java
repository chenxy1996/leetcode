package dp._97_困难_没有头绪_交错字符串;

public class Solution {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        int q = s3.length();
        if (m + n != q) {
            return false;
        }

    }
}
