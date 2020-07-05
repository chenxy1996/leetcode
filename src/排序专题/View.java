<<<<<<< HEAD
package 排序专题;

public class View {
    public static void viewArray(int[] nums, int[] markedList) {
        for (int i = 0; i < nums.length; i++) {
            if (isInMarkedList(i, markedList)) {
                String row = String.format("%03d", i);
                System.out.print(row + " ");
            } else {
                System.out.print("    ");
            }
            for (int j = 0; j < nums[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isInMarkedList(int target, int[] markedList) {
        int l = 0;
        int r = markedList.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (markedList[m] == target) {
                return true;
            } else if (markedList[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0 , 3, 2, 1, 7, 3, 4, 5};
        viewArray(nums, new int[] {1, 3});
    }
}
=======
package 排序专题;

public class View {
    public static void viewArray(int[] nums, int[] markedList) {
        for (int i = 0; i < nums.length; i++) {
            if (isInMarkedList(i, markedList)) {
                String row = String.format("%03d", i);
                System.out.print(row + " ");
            } else {
                System.out.print("    ");
            }
            for (int j = 0; j < nums[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isInMarkedList(int target, int[] markedList) {
        int l = 0;
        int r = markedList.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (markedList[m] == target) {
                return true;
            } else if (markedList[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0 , 3, 2, 1, 7, 3, 4, 5};
        viewArray(nums, new int[] {1, 3});
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
