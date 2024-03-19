package week2.BOJ_1158_S4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 0; i < N; i++) {
            deq.offer(i+1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K-1; j++) {
                deq.offer(deq.pollFirst());
            }
            sb.append(deq.pollFirst());
            if(deq.isEmpty()){
                sb.append(">");
            }
            else {
                sb.append(", ");
            }
        }

        System.out.println(sb);
    }
}
