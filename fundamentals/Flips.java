package fundamentals;

import edu.princeton.cs.algs4.StdRandom;

public class Flips {
    public static void main(String[] args) {
        int trials;
        if (args.length < 1) {
            trials = 10;
        }
        else {
            trials = Integer.parseInt(args[0]);
        }
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < trials; i++) {
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();
        }
        System.out.println(heads);
        System.out.println(tails);
        int delta = heads.tally() - tails.tally();
        System.out.printf("delta: %s%n", Math.abs(delta));
    }
}