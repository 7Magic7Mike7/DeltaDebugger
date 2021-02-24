package program;

import java.util.Arrays;

public class Test {

    public static boolean bubbleSort(Integer[] c) {
        final Integer[] copy = new Integer[c.length];
        System.arraycopy(c, 0, copy, 0, c.length);
        Arrays.sort(copy);
        BubbleSort.bubbleSort(c, c.length);
        for(int i = 0; i < c.length; i++) {
            if(!c[i].equals(copy[i]))
                return false;
        }
        return true;
    }
}
