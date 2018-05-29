package Question;

import java.util.HashMap;

/**
 *
 * @author omkar
 */
public class Fibonacci {

    HashMap<Integer, Integer> memo = new HashMap<>();

    public Fibonacci() {
        memo.put(0, 0);
        memo.put(1, 1);
    }

    public  int calculate(int num) {
        if (num < 0) {
            return 0;
        }
        return memo.computeIfAbsent(num, n -> calculate(n - 1) + calculate(n - 2));
    }

    public static void main(String[] args) {
        int fibonacci = new Fibonacci().calculate(9);
        System.out.println(fibonacci);
    }
}
