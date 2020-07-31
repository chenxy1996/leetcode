package 面试金典._08_递归问题._04_幂集;

import java.util.ArrayList;
import java.util.List;

public class OptimalSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> an : ans) {
                List<Integer> list = new ArrayList<>(an);
                list.add(num);
                tmp.add(list);
            }
            ans.addAll(tmp);
        }
        return ans;
    }
}
