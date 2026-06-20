package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseForstKElementFromQueue {

    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (q.isEmpty() || k <= 1 || q.size() < k) {
            return q;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        int remainingElements = q.size() - k;
        for (int i = 0; i < remainingElements; i++) {
            q.add(q.poll());
        }

        return q;
    }
}
