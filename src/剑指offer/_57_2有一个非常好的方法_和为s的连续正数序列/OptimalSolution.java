package 剑指offer._57_2有一个非常好的方法_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptimalSolution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;

        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        OptimalSolution solution = new OptimalSolution();
        int target = 15;
        System.out.println(Arrays.deepToString(solution.findContinuousSequence(target)));
    }
}
