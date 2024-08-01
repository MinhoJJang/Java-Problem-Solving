package week2.BOJ_11279_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bf.readLine());

            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    sb.append(x + "\n");
                } else {
                    sb.append(maxHeap.poll() + "\n");
                }
            } else {
                maxHeap.offer(x);
            }
        }
        System.out.println(sb);
    }
}
