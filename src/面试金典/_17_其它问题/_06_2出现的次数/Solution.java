package 面试金典._17_其它问题._06_2出现的次数;

/**
 * 迭代法，一个一个数
 */
public class Solution {
    public static int numberOf2sInRange(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int number = s.charAt(i) - '0';
            String left = s.substring(0, i);
            String right = s.substring(i + 1, len);
            int l = i == 0 ? 0 : Integer.parseInt(left);
            int r = i == len - 1 ? 0 : Integer.parseInt(right);
            if (number > 2) {
                ans += Math.pow(10, right.length()) * (l + 1);
            } else if (number < 2){
                ans += Math.pow(10, right.length()) * l;
            } else if (number == 2) {
                ans += Math.pow(10, right.length()) * l + r + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOf2sInRange(100));
    }
}
