package fundamentals;

public class Counter {
    private int tally;
    private String id;

    public Counter(String idInput) {
        // tally is a numeric primitive and will default to 0
        id = idInput;
    }

    public void increment() {
        tally += 1;
    }

    public int tally() {
        return tally;
    }

    public String toString() {
        return String.format("%s %s", tally, id);
    }

    public static Counter max(Counter x, Counter y) {
        if (x.tally() > y.tally()) return x;
        else return y;
    }

    public static void main(String[] args) {
        Counter counter = new Counter("foo");
        System.out.println(counter);
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
        System.out.println(counter);
    }
}