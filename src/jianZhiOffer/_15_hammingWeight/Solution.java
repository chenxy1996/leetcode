<<<<<<< HEAD
package jianZhiOffer._15_hammingWeight;

public class Solution {
    public int hammingWeight(int n) {
        int num = 0;

        while (n != 0) {
            num++;
            n &= n - 1;
        }

        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(3));
    }
}
=======
package jianZhiOffer._15_hammingWeight;

public class Solution {
    public int hammingWeight(int n) {
        int num = 0;

        while (n != 0) {
            num++;
            n &= n - 1;
        }

        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(3));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
