package newpackage;

import java.util.*;
import java.util.Map.Entry;

public class Anagram {

    static HashMap<Character, Integer> getMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
//        Map<Character, Integer> collect = s.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(c -> c, c -> 1,(a,b) -> a + b));
        for (char cc : s.toCharArray()) {
            int count = (map.containsKey(cc)) ? map.get(cc) : 0;
            map.put(cc,++count);
        }
        return map;
    }

    private static int findDelta(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2, HashSet<Character> set) {
        int delta = 0;
        for (Entry<Character, Integer> entry : map1.entrySet()) {
            if (!set.contains(entry.getKey())) {
                int count = (map2.containsKey(entry.getKey())) ? map2.get(entry.getKey()) : 0;
                delta += Math.abs(entry.getValue() - count);
                set.add(entry.getKey());
            }
        }
        return delta;
    }

    static int anagram(String s1, String s2) {
        HashMap<Character, Integer> map1 = getMap(s1);
        HashMap<Character, Integer> map2 = getMap(s2);
        HashSet<Character> set = new HashSet<>();
        return (findDelta(map1, map2, set) + findDelta(map2, map1, set)) / 2;
    }

    static int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }
        
        char[] chArr = s.toCharArray();
        char[] s1 = Arrays.copyOfRange(chArr, 0, chArr.length / 2);
        char[] s2 = Arrays.copyOfRange(chArr, chArr.length / 2, chArr.length);
        return anagram( s.substring(0, s.length() /2),s.substring(s.length() /2, s.length()));
    }


    public static void main(String[] args) {
        int result = anagram("xaxbbbxx");
        System.out.println(result);
        result = anagram("hhpddlnnsjfoyxpciioigvjqzfbpllssuj");
        System.out.println(result);
//        result = anagram("xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj");
//        System.out.println(result);
//        result = anagram("dnqaurlplofnrtmh");
//        System.out.println(result);
//        result = anagram("aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb");
//        System.out.println(result);
//        result = anagram("lbafwuoawkxydlfcbjjtxpzpchzrvbtievqbpedlqbktorypcjkzzkodrpvosqzxmpad");
//        System.out.println(result);
//        result = anagram("drngbjuuhmwqwxrinxccsqxkpwygwcdbtriwaesjsobrntzaqbe");
//        System.out.println(result);
//        result = anagram("ubulzt");
//        System.out.println(result);
//        result = anagram("vxxzsqjqsnibgydzlyynqcrayvwjurfsqfrivayopgrxewwruvemzy");
//        System.out.println(result);
//        result = anagram("xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa");
//        System.out.println(result);
//        result = anagram("gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv");
//        System.out.println(result);
//            result = anagram("ab");
//            System.out.println(result);
//            result = anagram("abc");
//            System.out.println(result);
//            result = anagram("mnop");
//            System.out.println(result);
//            result = anagram("xyyx");
//            System.out.println(result);
    }
}
