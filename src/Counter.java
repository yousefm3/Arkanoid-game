/**
 * @author Mohamed Yousef
 */
public class Counter {
    private int count;

    /**
     * @param num the count num
     */
    public Counter(int num) {
        this.count = num;
    }
    /**
     * add number to current count.
     * @param number the number to add
     */
   public void increase(int number) {
       this.count = this.count + number;
   }

    /**
     * subtract number from current count.
     * @param number the number to decrease
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * @return the count
     */
    public int getValue() {
    return this.count;
    }
}