package delta_debugger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DDmin {
    private final Function<Integer[], Boolean> test;

    public DDmin(Function<Integer[], Boolean> test) {
        this.test = test;
    }

    public Integer[] execute(Integer[] input) {
        if(test.apply(input)) return new Integer[0];
        return ddmin(input, 2);
    }

    private Integer[] ddmin(Integer[] c, int n) {
        if(c.length == 1) return c;

        final Integer[][] splits = subarrays(c, n);
        for(int i = 0; i < n; i++) {
            Integer[] cxi = splits[i];           //c \ ci
            if(!test.apply(cxi))
                return ddmin(cxi, Math.max(n-1, 2));
        }

        if(n < c.length) return ddmin(c, Math.min(2*n, c.length));
        return c;
    }

    private static Integer[][] subarrays(Integer[] arr, int n) {
        final int[] sizes = sizes(arr.length, n);
        final Integer[][] splitted = new Integer[n][];
        final List<Integer> data = Arrays.asList(arr);

        for(int i = 0; i < n-1; i++) {
            final int size = sizes[i];
            splitted[i] = new Integer[arr.length - size];
            System.arraycopy(
                    data.subList(0, i * size).toArray(new Integer[0]), 0, //(n-2) * size .. (n-1) * size
                    splitted[i], 0,
                    i * size
            );

            System.arraycopy(
                    data.subList((i+1) * size, data.size()).toArray(new Integer[0]), 0,
                    splitted[i], i * size,
                    data.size() - (i+1) * size
            );
        }
        splitted[n-1] = new Integer[(n-1) * sizes[n-1]];
        System.arraycopy(
                data.subList(0, (n-1) * sizes[n-1]).toArray(new Integer[0]), 0,
                splitted[n-1], 0,
                (n-1) * sizes[n-1]
        );

        return splitted;
    }

    /**
     *
     * @param len
     * @param n
     * @return
     */
    private static int[] sizes(int len, int n) {
        final int[] sizes = new int[n];
        sizes[0] = len / n;
        for(int i = 1; i < n; i++) {
            len = len - sizes[i-1];
            sizes[i] = len / (n-i);
        }
        return sizes;
    }
}
