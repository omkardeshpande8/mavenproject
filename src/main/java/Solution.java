
import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

public class Solution {

    static class Row {

        String identifier;
        String content;

        public Row(String i, String c) {
            identifier = i;
            content = c;
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<String> reorderLines(int logFileSize, List<String> logfile) {
        // WRITE YOUR CODE HERE
        List<String> numericRows = new LinkedList<>();
        List<String> alphabeticRows = new LinkedList<>();
        //List<Row> rowList =  new LinkedList<>();
        PriorityQueue<Row> pq = new PriorityQueue<Row>(new Comparator<Row>() {
            @Override
            public int compare(Row r1, Row r2) {
                int comp = r1.content.compareTo(r2.content);
                if (comp == 0) {
                    return r1.identifier.compareTo(r2.identifier);
                }
                return comp;
            }
        });
        for (String str : logfile) {
            String identifier = str.substring(0, str.indexOf(' '));
            String content = str.substring(str.indexOf(' ') + 1);
            //  System.out.println(identifier + " " + content);
            if (content.matches(".*\\d+.*")) {
                numericRows.add(str);
            } else {
                pq.offer(new Row(identifier, content));
            }
        }
        while(pq.size() > 0) {
            Row poll = pq.poll();
            alphabeticRows.add(poll.identifier + " " + poll.content);
        }
        alphabeticRows.addAll(numericRows);
        return alphabeticRows;
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("t2 13 121 98");
        l.add("r1 box ape bit");
        l.add("b4 xi me nu");
        l.add("br8 eat nim did");
        l.add("w1 has uni gry");
        l.add("f3 52 54 31");
//        l.add("br has");
        List<String> reorderLines = reorderLines(2, l);
        reorderLines.forEach(System.out::println);
    }
}
