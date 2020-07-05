<<<<<<< HEAD
package dfs._78_子集;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

// 用迭代速度更快更加好
public class Solution {
    public List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        recur(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void recur(int[] nums, int p, List<Integer> temp, List<List<Integer>> res) {
        if (nums.length == p) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = p; i < nums.length; i++) {
                // 当前 i 所指的元素加入 temp 中
                temp.add(nums[i]);

                // 不向 temp 中添加别的元素了
                recur(nums, nums.length, temp, res);

                // 继续向 temp 中添加别的元素
                if (i < nums.length - 1)
                    recur(nums, i + 1, temp, res);

                // 返回原来的状态
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subSets(new int[]{1, 2, 3}));
    }
}
=======
package dfs._78_子集;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

// 用迭代速度更快更加好
public class Solution {
    public List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        recur(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void recur(int[] nums, int p, List<Integer> temp, List<List<Integer>> res) {
        if (nums.length == p) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = p; i < nums.length; i++) {
                // 当前 i 所指的元素加入 temp 中
                temp.add(nums[i]);

                // 不向 temp 中添加别的元素了
                recur(nums, nums.length, temp, res);

                // 继续向 temp 中添加别的元素
                if (i < nums.length - 1)
                    recur(nums, i + 1, temp, res);

                // 返回原来的状态
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subSets(new int[]{1, 2, 3}));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
