//ID: 322225897.

/**
 * the counter helps to count different objects in the game.
 * implemented by a int field that counts.
 * support constructor,increase,decrease and get value methods.
 */
public class Counter {
    private int count;

    /**
     * constructor.
     *
     * @param number a start number for the counters' value.
     */
    public Counter(int number) {
        this.count = number;
    }

    /**
     * add number to current count.
     *
     * @param number the added number.
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number the added number.
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * get current count.
     *
     * @return the counter value.
     */
    public int getValue() {
        return this.count;
    }
}