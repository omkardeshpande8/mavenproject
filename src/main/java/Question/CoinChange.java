package Question;

import java.util.HashMap;

/**
 *
 * @author omkar
 */
public class CoinChange {

    static HashMap<String, Long> map = new HashMap<>();

    public static Long countWays(int[] coins, int money, int index) {

        if (money == 0) {
            return 1l;
        }
        if (index >= coins.length) {
            return 0l;
        }
        String key = money + "-" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        long ways = 0;

        for (int i = 0; i <= money / coins[index]; i++) {
            ways += countWays(coins, money - (i * coins[index]), index + 1);
        }
        map.put(key, ways);
        return ways;
    }

    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static Integer minCoins(int[] coins, int money) {
        if (money == 0) {
            return 0;
        }
        if (money < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo.containsKey(money)) {
            return memo.get(money);
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = minCoins(coins, money - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo.put(money, min);
        return min;
    }

//    public static Integer minCoins(int[] coins, int money) {
//        int result = minCoins(coins, money, 0);
//        return (result == Integer.MAX_VALUE) ? 0 : result;
//    }
    public static void main(String[] args) {
        int[] coins = {1,5,10};
        System.out.println(countWays(coins, 10, 0));

        int coins2[] = {9, 6, 1, 5};
        int V = 11;
        System.out.println(minCoins(coins2, V));

    }
}
