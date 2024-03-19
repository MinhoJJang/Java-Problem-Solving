package week2.BOJ_10866_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        Deque<Integer> deq = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String order = bf.readLine();
            String[] order_arr = order.split(" ");

            switch (order_arr[0]) {
                case "push_back":
                    deq.offerLast(Integer.valueOf(order_arr[1]));
                    break;

                case "push_front":
                    deq.offerFirst(Integer.valueOf(order_arr[1]));
                    break;
                case "pop_front":
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deq.pollFirst() + "\n");
                    }
                    break;
                case "pop_back":
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deq.pollLast() + "\n");
                    }
                    break;
                case "size":
                    sb.append(deq.size() + "\n");
                    break;
                case "empty":
                    if (deq.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deq.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deq.peekLast() + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
}
