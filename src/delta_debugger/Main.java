package delta_debugger;

import program.Test;

public class Main {

    public static void main(String[] args) {
        IntArray arr = new IntArray(1, 6, 9, 7, 5);
        final DDmin<Integer[]> ddmin = new DDmin<>(Test::bubbleSort);
        final Integer[] min = ddmin.execute(arr);
        if(min == null) System.out.println("Input is correct, so nothing to do.");
        else for(final int i : min) System.out.println(i);
    }
}
