package jianzhioffer;

public class P10_1_Fibonacci {
    // the anwser need mod 1e9+7（1000000007）to avoid overflow

    // recursive O(n!)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // use an array for caching
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] cache = { 0, 1, 1 };
        int position = 2;
        int count = n - 1;
        while (count > 0) {
            cache[position] = (cache[(position + 1) % 3] + cache[(position + 2) % 3]) % 1000000007;
            position = (position + 1) % 3;
            count--;
        }
        return cache[(position + 2) % 3];
    }

    // like fib2 use int instead of int[]
    public int fib3(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        P10_1_Fibonacci s = new P10_1_Fibonacci();

        System.out.println(s.fib(45));
        System.out.println(s.fib2(45));
    }
}
