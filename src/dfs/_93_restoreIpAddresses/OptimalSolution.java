<<<<<<< HEAD
package dfs._93_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OptimalSolution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        reccur(s, new ArrayList<>(), 0, res);
        return res;
    }

    private void reccur(String s, List<String> temp, int level, List<String> res) {
        if (s.length() == 0) {
            if (level == 4) {
                res.add(temp.stream().collect(Collectors.joining(",")));
            }
        } else {
            // 最多就取三个数
            for (int i = 0; i < 3 && i < s.length(); i++) {
                if (i == 0 && s.charAt(i) == '0') {
                    temp.add("0");
                    reccur(s.substring(1), temp, level + 1, res);
                    temp.remove(temp.size() - 1);
                    break;
                } else {
                    String s1 = s.substring(0, i + 1);
                    int anInt = Integer.parseInt(s1);
                    if (anInt <= 255) {
                        temp.add(s1);
                        reccur(s.substring(i + 1), temp, level + 1, res);
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OptimalSolution solution = new OptimalSolution();
        System.out.println(solution.restoreIpAddresses("2550123115"));

        String s = "123";
    }
}
=======
package dfs._93_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OptimalSolution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        reccur(s, new ArrayList<>(), 0, res);
        return res;
    }

    private void reccur(String s, List<String> temp, int level, List<String> res) {
        if (s.length() == 0) {
            if (level == 4) {
                res.add(temp.stream().collect(Collectors.joining(",")));
            }
        } else {
            // 最多就取三个数
            for (int i = 0; i < 3 && i < s.length(); i++) {
                if (i == 0 && s.charAt(i) == '0') {
                    temp.add("0");
                    reccur(s.substring(1), temp, level + 1, res);
                    temp.remove(temp.size() - 1);
                    break;
                } else {
                    String s1 = s.substring(0, i + 1);
                    int anInt = Integer.parseInt(s1);
                    if (anInt <= 255) {
                        temp.add(s1);
                        reccur(s.substring(i + 1), temp, level + 1, res);
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OptimalSolution solution = new OptimalSolution();
        System.out.println(solution.restoreIpAddresses("2550123115"));

        String s = "123";
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
