package delta_debugger;

import java.util.Arrays;
import java.util.List;

public class IntArray implements InputType<Integer[]> {
    private final Integer[] arr;

    public IntArray(Integer... values) {
        this.arr = values;
    }

    @Override
    public Integer[] get() {
        return arr;
    }

    @Override
    public int length() {
        return arr.length;
    }

    public InputType<Integer[]>[]  split(int n) {
        final int[] sizes = InputType.sizes(arr.length, n);

        final InputType<Integer[]>[] splitted = new IntArray[n];
        final List<Integer> data = Arrays.asList(arr);

        for(int i = 0; i < n-1; i++) {
            final int size = sizes[i];
            final Integer[] split = new Integer[arr.length - size];
            System.arraycopy(
                    data.subList(0, i * size).toArray(new Integer[0]), 0, //(n-2) * size .. (n-1) * size
                    split, 0,
                    i * size
            );

            System.arraycopy(
                    data.subList((i+1) * size, data.size()).toArray(new Integer[0]), 0,
                    split, i * size,
                    data.size() - (i+1) * size
            );
            splitted[i] = new IntArray(split);
        }
        final Integer[] split = new Integer[(n-1) * sizes[n-1]];
        System.arraycopy(
                data.subList(0, (n-1) * sizes[n-1]).toArray(new Integer[0]), 0,
                split, 0,
                (n-1) * sizes[n-1]
        );
        splitted[n-1] = new IntArray(split);

        return splitted;
    }
}
