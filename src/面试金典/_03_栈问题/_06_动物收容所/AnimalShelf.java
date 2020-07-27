package 面试金典._03_栈问题._06_动物收容所;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class AnimalShelf {
    private LinkedList<int[]> elements = new LinkedList<>();

    public AnimalShelf() {
    }

    public void enqueue(int[] animal) {
        elements.add(animal);
    }

    public int[] dequeueAny() {
        if (elements.size() > 0) {
            return elements.removeFirst();
        } else {
            return new int[] {-1, -1};
        }
    }

    public int[] dequeueDog() {
        Iterator<int[]> iterator = elements.iterator();
        while (iterator.hasNext()) {
            int[] elem = iterator.next();
            if (elem[1] == 1) {
                iterator.remove();
                return elem;
            }
        }
        return new int[] {-1, -1};
    }

    public int[] dequeueCat() {
        Iterator<int[]> iterator = elements.iterator();
        while (iterator.hasNext()) {
            int[] elem = iterator.next();
            if (elem[1] == 0) {
                iterator.remove();
                return elem;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        AnimalShelf as = new AnimalShelf();
//        System.out.println(Arrays.toString(as.dequeueCat()));
//        System.out.println(Arrays.toString(as.dequeueDog()));
        as.enqueue(new int[] {0, 0});
        as.enqueue(new int[] {1, 0});
        System.out.println(Arrays.toString(as.dequeueCat()));
        System.out.println(Arrays.toString(as.dequeueDog()));
        System.out.println(Arrays.toString(as.dequeueAny()));
    }
}
