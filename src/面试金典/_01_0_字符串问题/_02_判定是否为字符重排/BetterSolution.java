package 面试金典._01_0_字符串问题._02_判定是否为字符重排;

// 字符相加和相乘的结果分别相等就说明是
public class BetterSolution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] res1 = {0, 1};
        int[] res2 = {0, 1};
        s1.chars().forEach(x -> {
            res1[0] += x;
            res1[1] *= x;
        });
        s2.chars().forEach(x -> {
            res2[0] += x;
            res2[1] *= x;
        });
        return res1[0] == res2[0] && res1[1] == res2[1];
    }
}
