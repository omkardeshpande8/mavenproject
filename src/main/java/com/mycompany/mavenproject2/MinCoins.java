package com.mycompany.mavenproject2;

import java.util.Arrays;

class MinCoins {

    static int minCoins(int coins[], int V) {
        int m = coins.length;
        int table[] = new int[V + 1];
        table[0] = 0;
        Arrays.fill(table, Integer.MAX_VALUE);

        for (int i = 1; i <= V; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
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
