package delta_debugger;

import java.util.function.Function;

public class DDmin<T> {
    private final Function<T, Boolean> test;

    public DDmin(Function<T, Boolean> test) {
        this.test = test;
    }

    public T execute(InputType<T> input) {
        if(test.apply(input.get())) return null;
        return ddmin(input, 2);
    }

    private T ddmin(InputType<T> c, int n) {
        if(c.length() == 1) return c.get();

        final InputType<T>[] splits = c.split(n);
        for(int i = 0; i < n; i++) {
            InputType<T> cxi = splits[i];           //c \ ci
            if(!test.apply(cxi.get()))
                return ddmin(cxi, Math.max(n-1, 2));
        }

        if(n < c.length()) return ddmin(c, Math.min(2*n, c.length()));
        return c.get();
    }
}
