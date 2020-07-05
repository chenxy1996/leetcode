<<<<<<< HEAD
package dfs._93_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        reccur(0, s, new ArrayList<>(), 0, res);
        return res;
    }

    private void reccur(int i, String s, List<String> temp, int level, List<String> res) {
        // s 中没有剩余的数字了, 而且已经构成好了一个有效的 ip 地址
        if (i == s.length() && level == 4) {
            String ip = temp.stream().collect(Collectors.joining("."));
            res.add(ip);
            return;
        }

        if (level < 4) {
            for (int p = i; p <= s.length() - 1; p++) {
                // 开头也就是 i 的位置上是 0 就必须要在 0 后断
                if (p == i && s.charAt(p) == '0') {
                    temp.add("0");
                    reccur(i + 1, s, temp,level + 1, res);

                    temp.remove(temp.size() - 1);
                    // 跳出循环
                    break;
                } else {
                    // 开头位置不是 0
                    // 判断是否在[0, 255]
                    if (isValid(i, p, s)) {
                        temp.add(s.substring(i, p + 1));
                        reccur(p + 1, s, temp, level + 1, res);

                        temp.remove(temp.size() - 1);
                    } else {
                        // 不在 [0, 255], 跳出循环
                        break;
                    }
                }
            }
        }
    }

    private boolean isValid(int start, int end, String s) {
        int res = 0;

        for (int i = start; i <= end; i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }

        return 0 <= res && res <= 255;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isValid(0, 2, "257"));
        System.out.println(solution.restoreIpAddresses("19216801"));

    }
}
=======
package dfs._93_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        reccur(0, s, new ArrayList<>(), 0, res);
        return res;
    }

    private void reccur(int i, String s, List<String> temp, int level, List<String> res) {
        // s 中没有剩余的数字了, 而且已经构成好了一个有效的 ip 地址
        if (i == s.length() && level == 4) {
            String ip = temp.stream().collect(Collectors.joining("."));
            res.add(ip);
            return;
        }

        if (level < 4) {
            for (int p = i; p <= s.length() - 1; p++) {
                // 开头也就是 i 的位置上是 0 就必须要在 0 后断
                if (p == i && s.charAt(p) == '0') {
                    temp.add("0");
                    reccur(i + 1, s, temp,level + 1, res);

                    temp.remove(temp.size() - 1);
                    // 跳出循环
                    break;
                } else {
                    // 开头位置不是 0
                    // 判断是否在[0, 255]
                    if (isValid(i, p, s)) {
                        temp.add(s.substring(i, p + 1));
                        reccur(p + 1, s, temp, level + 1, res);

                        temp.remove(temp.size() - 1);
                    } else {
                        // 不在 [0, 255], 跳出循环
                        break;
                    }
                }
            }
        }
    }

    private boolean isValid(int start, int end, String s) {
        int res = 0;

        for (int i = start; i <= end; i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }

        return 0 <= res && res <= 255;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isValid(0, 2, "257"));
        System.out.println(solution.restoreIpAddresses("19216801"));

    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
