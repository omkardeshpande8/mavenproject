package newpackage;

import java.util.HashMap;

public class Trie {

    private static class Node {

        char ch;
        boolean isEnd;

        HashMap<Character, Node> set = new HashMap<>();

        private Node(char ch) {
            this.ch = ch;
        }
    }

    static Node root = new Node('0');

    private static void addWord(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.set.containsKey(ch)) {
                current.set.put(ch, new Node(ch));
            }
            current = current.set.get(ch);
        }
        current.isEnd = true;
    }

    public static String getMatchingPrefix(String input) {
        String result = "";
        Node current = root;
        int level = 0, match = 0;
        for (char ch : input.toCharArray()) {
            if (current.set.containsKey(ch)) {
                if (current.isEnd) {
                    match = level;
                }
                result += ch;
                current = current.set.get(ch);
            } else {
                break;
            }
            level++;
        }

        if (!current.isEnd) {
            return result.substring(0, match);
        }

        return result;
    }

    public static void main(String[] args) {
//        addWord("hackerrank");
//        addWord("hack");
        addWord("are");
        addWord("area");
        addWord("base");
        addWord("cat");
        addWord("cater");
        addWord("basement");
        getMatchingPrefix("basemxy");
    }
}
