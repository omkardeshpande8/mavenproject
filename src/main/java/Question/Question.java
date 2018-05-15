package Question;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Question {

    static Map<Integer, Integer> map = Arrays.asList(new SimpleEntry<>(0, 1)).stream().collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));

    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        }
        map.putIfAbsent(n, countWays(n - 1) + countWays(n - 2) + countWays(n - 3));
        return map.get(n);
    }

    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
            return map[n];
        }
    }

    public static int countWaysRecursive(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 30; i++) {
//            long t1 = System.currentTimeMillis();
//            int[] map = new int[30 + 1];
//            for (int j = 0; j < map.length; j++) {
//                map[j] = -1;
//            }
//            int c1 = countWaysDP(i, map);
//            long t2 = System.currentTimeMillis();
//            long d1 = t2 - t1;
//
//            long t3 = System.currentTimeMillis();
//            int c2 = countWaysRecursive(i);
//            long t4 = System.currentTimeMillis();
//            long d2 = t4 - t3;
//            System.out.println(i + " " + c1 + " " + c2 + " " + d1 + " " + d2);
//        }
        int c1 = countWaysRecursive(7);
        System.out.println(c1);
        int c3 = countWays(7);

        System.out.println(c3);

    }

}
