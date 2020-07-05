<<<<<<< HEAD
package jianZhiOffer._38_med外观数列;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String s = countAndSay(n - 1);

            String res = "";
            char preChar = s.charAt(0);
            int count = 1;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (s.charAt(i) != preChar) {
                    res += String.valueOf(count) + String.valueOf(preChar);
                    count = 1;
                    preChar = s.charAt(i);
                } else {
                    count++;
                }
            }

            return res += String.valueOf(count) + String.valueOf(preChar);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(5));
    }
}
=======
package jianZhiOffer._38_med外观数列;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String s = countAndSay(n - 1);

            String res = "";
            char preChar = s.charAt(0);
            int count = 1;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (s.charAt(i) != preChar) {
                    res += String.valueOf(count) + String.valueOf(preChar);
                    count = 1;
                    preChar = s.charAt(i);
                } else {
                    count++;
                }
            }

            return res += String.valueOf(count) + String.valueOf(preChar);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(5));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
