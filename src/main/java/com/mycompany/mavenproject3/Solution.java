package com.mycompany.mavenproject3;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 *
 * @author omkar
 */
public class Solution {

    class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void reverseWords(char[] s) {
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            if (s[j] == ' ' || j == s.length - 1) {
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }
        reverse(s, 0, s.length - 1);
        System.out.println(new String(s));

    }

    public static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    boolean hasCircle(Node root) {
        Node slower = root;
        Node faster = root;
        while (true) {
            // increment the iterators, if either is at the end, you're done, no circle
            if (slower.next != null) {
                slower = slower.next;
            } else {
                return false;
            }

            // second iterator is travelling twice as fast as first
            if (faster.next != null && faster.next.next != null) {
                faster = faster.next.next;
            } else {
                return false;
            }

            // this should be whatever test shows that the two
            // iterators are pointing at the same place
            if (slower.val == faster.val) {
                return true;
            }
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = s.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(x -> x, x -> 1, (x, y) -> x + y));

        for (int i = 0; i < s.length(); i++) {
            char c2 = t.charAt(i);
            if (map.containsKey(c2)) {
                if (map.get(c2) == 1) {
                    map.remove(c2);
                } else {
                    map.put(c2, map.get(c2) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//start from an empty list
        result.add(new ArrayList<>());
        for (int i = 0; i < num.length; i++) {
//list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();
            for (ArrayList<Integer> l : result) {
// # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
// + add num[i] to different locations
                    l.add(j, num[i]);
                    ArrayList<Integer> temp = new ArrayList<>(l);
                    current.add(temp);
//System.out.println(temp);
// - remove num[i] add
                    l.remove(j);
                }
            }
            result = new ArrayList<>(current);
        }
        return result;
    }

    public static void main(String[] args) {
//        String s = "getting   good at coding needs a lot of practice";
//        reverseWords(s.toCharArray());
        //System.out.println(s);
//        int[] a = {3, 2, 1, 5, 6, 4};
//        int findKthLargest = findKthLargest(a, 2);
//        System.out.println(findKthLargest);
        int[] a = {1, 2, 3};
        permute(a);
    }
}
