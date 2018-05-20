/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.PriorityQueue;

public class RunningMedian {

    private static double[] median(int[] a) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((p, b) -> b - p);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        double[] medians = new double[a.length];
        int j = 0;
        for (int i : a) {
            addToHeap(i, minHeap, maxheap);
            balanceHeaps(minHeap, maxheap);
            medians[j++] = getMedian(minHeap, maxheap);
        }
        return medians;
    }

    private static void addToHeap(int i, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxheap) {
        if (maxheap.isEmpty() || i < maxheap.peek()) {
            maxheap.offer(i);
        } else {
            minHeap.offer(i);
        }
    }

    private static void balanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxheap) {
        if (Math.abs(minHeap.size() - maxheap.size()) > 1) {
            if (minHeap.size() > maxheap.size()) {
                maxheap.offer(minHeap.poll());
            } else {
                minHeap.offer(maxheap.poll());
            }
        }
    }

    private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxheap) {
        if (minHeap.size() == maxheap.size()) {
            return (double) (minHeap.peek() + maxheap.peek()) / 2;
        } else {
            if (minHeap.size() > maxheap.size()) {
                return (minHeap.peek());
            } else {
                return (maxheap.peek());
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 4, 5, 3, 8, 7};
        double[] medians = median(a);
        for (double m : medians) {
            System.out.println(m);
        }
    }

}
