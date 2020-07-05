package binarySearch;

public class SearchBound2 {
    public static int searchLeftBound(int[] nums, int t) {
        int l = 0;
        int r = nums.length;

        while(l <= r) {
            int m = ((r - l) >> 1) + l;
            if(nums[m] < t)
                l = m + 1;
            else
                r = m - 1;
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 5};
        System.out.println(searchLeftBound(nums, 0));
    }
}
