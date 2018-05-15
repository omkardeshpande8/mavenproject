//package newpackage;
//
//import java.util.AbstractMap.SimpleEntry;
//import java.util.*;
//import java.util.stream.*;
//
//public class Solution {
//
//    public List<Integer> topKFrequent(int[] nums, int k) {
////count the frequency for each element
//        Stream<Integer> boxed = IntStream.of(nums).boxed();
//        Map<Integer,Integer> map  = IntStream.of(nums).boxed().collect(Collectors.toMap(key -> key, value -> 1, (value1, value2) -> value1 + value2));
//// create a min heap
//        PriorityQueue<SimpleEntry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(SimpleEntry::getValue));
////maintain a heap of size k.
//        map.entrySet().forEach(entry -> {
//            SimpleEntry p = new SimpleEntry(entry.getKey(), entry.getValue());
//            queue.offer(p);
//            if (queue.size() > k) {
//                queue.poll();
//            }
//        });
//
////get all elements from the heap
//        List<Integer> result = new ArrayList<>();
//        while (queue.size() > 0) {
//            result.add(queue.poll().getKey());
//        }
////reverse the order
//        Collections.reverse(result);
//        return result;
//    }
//}
