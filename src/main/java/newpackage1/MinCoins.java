package newpackage1;

import java.util.Arrays;

class MinCoins {

    static int minCoins(int coins[], int V) {
        int table[] = new int[V + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for (int j = 0; j < coins.length; j++) {
            for (int i = coins[j]; i <= V; i++) {
                // Go through all coins smaller than i
                int sub_res = table[i - coins[j]] + 1 ;
                if (sub_res != Integer.MAX_VALUE && sub_res < table[i]) {
                    table[i] = sub_res;
                }
            }

        }

        return table[V];
    }

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int V = 11;
        System.out.println("Minimum coins required is " + minCoins(coins, V));
    }
}
