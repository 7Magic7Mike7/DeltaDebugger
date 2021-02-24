package delta_debugger;

public interface InputType<T> {
    /**To make splitting easier this function calculates the sizes of
     * the multiple parts of a uniform split.
     *
     * @param len length of the data we want to uniformly split
     * @param n number of parts after splitting
     * @return array of sizes for uniform splits
     */
    static int[] sizes(int len, int n) {
        final int[] sizes = new int[n];
        sizes[0] = len / n;
        for(int i = 1; i < n; i++) {
            len = len - sizes[i-1];
            sizes[i] = len / (n-i);
        }
        return sizes;
    }

    /**Used to unwrap the data.
     *
     * @return original data without wrapping
     */
    T get();

    /**There must be some sort of "length"-attribute in the data for the splitting to work.
     *
     * @return some kind of length/size of the underlying data
     */
    int length();

    /**Splits the underlying data into n parts. Each part should have approximately the same length.
     *
     * @param n number of parts after split
     * @return array of sub-versions of the data
     */
    InputType<T>[] split(int n);
}
