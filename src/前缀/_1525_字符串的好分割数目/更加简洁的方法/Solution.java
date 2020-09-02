package 前缀和._1525_字符串的好分割数目.更加简洁的方法;

public class Solution {
    public static int numSplits(String s) {
        int n = s.length(), count = 0;
        int[] left = new int[256], right = new int[256];
        for(char c : s.toCharArray()) {
            if(right[c]++ == 0) count++;
        }
        int res = 0, l = 0, r = count;
        for(int i = 0; i < n - 1; i++) {
            char c = s.charAt(i);
            if(left[c]++ == 0) l++;
            if(--right[c] == 0) r--;
            if(l == r) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aacaba";
        System.out.println(numSplits(s));
    }
}
