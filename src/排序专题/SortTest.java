<<<<<<< HEAD
package 排序专题;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SortTest {
    public static boolean test(Consumer<int[]> sortFunction) {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            int size;
            while ((size = random.nextInt(30)) <= 0) {
            }
            int[] ints = random.ints(size, -20, 20).toArray();
            sortFunction.accept(ints);

            // 测试是否排序玩
            int k = 0;
            while (k < ints.length - 1) {
                if (ints[k] > ints[k + 1]) {
                    System.out.println(i + " --------------------------------------------------------");
                    System.out.println("after sort: " + Arrays.toString(ints));
                    System.out.println("----------------------------------------------------------");
                    System.out.println("ints[" + k + "]: " + ints[k]);
                    System.out.println("ints[" + k + 1 + "]: " + ints[k + 1]);
                    return false;
                }
                k++;
            }
        }

        return true;
    }
}
=======
package 排序专题;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SortTest {
    public static boolean test(Consumer<int[]> sortFunction) {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            int size;
            while ((size = random.nextInt(30)) <= 0) {
            }
            int[] ints = random.ints(size, -20, 20).toArray();
            sortFunction.accept(ints);

            // 测试是否排序玩
            int k = 0;
            while (k < ints.length - 1) {
                if (ints[k] > ints[k + 1]) {
                    System.out.println(i + " --------------------------------------------------------");
                    System.out.println("after sort: " + Arrays.toString(ints));
                    System.out.println("----------------------------------------------------------");
                    System.out.println("ints[" + k + "]: " + ints[k]);
                    System.out.println("ints[" + k + 1 + "]: " + ints[k + 1]);
                    return false;
                }
                k++;
            }
        }

        return true;
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
