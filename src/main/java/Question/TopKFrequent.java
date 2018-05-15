package Question;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

/**
 *
 * @author omkar
 */
public class TopKFrequent {

    HashMap<String, Integer> map = new HashMap<>();
    PriorityQueue<SimpleEntry<String, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

    private final int size;

    private TopKFrequent(int i) {
        size = i;
    }

    public void addWord(String str) {
        if (!map.containsKey(str)) {
            map.put(str, 1);
            heap.offer(new SimpleEntry<>(str, 1));
        } else {
            int count = map.get(str);
            heap.remove(new SimpleEntry<>(str, count));
            map.put(str, ++count);
            heap.offer(new SimpleEntry<>(str, count));
            if (heap.size() > size) {
                heap.poll();
            }
        }
    }

    public List<String> getTopKFrequent() {
        return heap.stream().map(SimpleEntry::getKey).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TopKFrequent nt = new TopKFrequent(2);
        nt.addWord("abc");
        nt.addWord("pqr");
        nt.addWord("abc");
        nt.addWord("abc");
        nt.addWord("xyz");
        nt.addWord("xyz");
        nt.addWord("xyz");
        List<String> topKFrequent = nt.getTopKFrequent();
        topKFrequent.forEach(System.out::println);
        nt.addWord("pqr");
        nt.addWord("pqr");
        topKFrequent = nt.getTopKFrequent();
        topKFrequent.forEach(System.out::println);
    }
}
