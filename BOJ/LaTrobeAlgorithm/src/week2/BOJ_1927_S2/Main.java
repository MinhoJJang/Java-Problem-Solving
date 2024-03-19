package week2.BOJ_1927_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bf.readLine());

            if (x == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(x + "\n");
                } else {
                    sb.append(minHeap.poll() + "\n");
                }
            } else {
                minHeap.offer(x);
            }
        }
        System.out.println(sb);
    }
}
