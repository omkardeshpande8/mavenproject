package com.mycompany.mavenproject3;

import java.util.Stack;

class Queue {

    Stack<Integer> stack1 = new Stack<>();

    Stack<Integer> stack2 = new Stack<>();

    int popFromStack2() {
        if (stack2.isEmpty()) {
            System.out.println("Stack Overflow");
            System.exit(0);
        }
        return stack2.pop();
    }

    void enQueue(int x) {
        stack1.push(x);
    }

    /* Function to dequeue an item from queue */
    int deQueue() {
        int x;
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Q is empty");
            System.exit(0);
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        x = popFromStack2();
        return x;
    }

}

public class GFG {

    public static void main(String args[]) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.print(q.deQueue() + " ");
        q.enQueue(4);
        System.out.print(q.deQueue() + " ");
        q.enQueue(5);
        System.out.println(q.deQueue() + " ");
        System.out.println(q.deQueue() + " ");
        System.out.println(q.deQueue() + " ");

    }
}
