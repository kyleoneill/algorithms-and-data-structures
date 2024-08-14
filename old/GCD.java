package fundamentals;

public class GCD {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int first = 200;
        int second = 288;
        int res = gcd(first, second);
        System.out.print(String.format("The GCD of %s and %s is %s", first, second, res));
    }
}
