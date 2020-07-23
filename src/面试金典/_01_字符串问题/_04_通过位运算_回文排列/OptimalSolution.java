package 面试金典._01_字符串问题._04_通过位运算_回文排列;

import java.util.BitSet;

public class OptimalSolution {
    public boolean canPermutePalindrome(String s) {
        BitSet set = new BitSet(128);
        for (int i = 0; i < s.length(); i++) {
            int p = s.charAt(i);
            set.flip(p);
        }
        return set.cardinality() <= 1;
    }
}
