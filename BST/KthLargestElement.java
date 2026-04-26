package BST;
import java.util.*;

public class KthLargestElement {

        PriorityQueue<Integer> minHeap;
        int k;

        public KthLargestElement(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();

            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);

            if (minHeap.size() > k) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }

