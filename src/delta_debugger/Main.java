package delta_debugger;

import program.BubbleSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = { 1, 6, 9, 7, 5 };
        DDmin ddmin = new DDmin(Main::test);
        final Integer[] min = ddmin.execute(arr);
        for(final int i : min) System.out.println(i);
    }

    private static boolean test(Integer[] c) {
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
