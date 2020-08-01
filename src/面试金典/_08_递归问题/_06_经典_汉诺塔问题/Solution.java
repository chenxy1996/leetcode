package 面试金典._08_递归问题._06_经典_汉诺塔问题;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
        } else {
            move(n - 1, A, C, B);
            C.add(A.remove(A.size() - 1));
            move(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> C = new ArrayList<>();
        new Solution().hanota(A, new ArrayList<>(), C);
        System.out.println(C);
    }
}
