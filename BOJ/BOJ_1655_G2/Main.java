package week2.BOJ_1655_G2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bf.readLine());

            if (maxHeap.isEmpty() || x < maxHeap.peek()) {
                maxHeap.offer(x);
            } else {
                minHeap.offer(x);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }
}