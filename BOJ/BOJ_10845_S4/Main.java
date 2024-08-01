package week2.BOJ_10845_S4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deq = new LinkedList<>();

        int N = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String order = sc.nextLine();
            String[] order_arr = order.split(" ");

            switch (order_arr[0]){
                case "push":
                    deq.offer(Integer.valueOf(order_arr[1]));
                    break;
                case "pop":
                    if(deq.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(deq.pollFirst()+"\n");
                    }
                    break;
                case "size":
                    sb.append(deq.size()+"\n");
                    break;
                case "empty":
                    if(deq.isEmpty()){
                        sb.append("1\n");
                    }
                    else{
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if(deq.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(deq.peekFirst()+"\n");
                    }
                    break;
                case "back":
                    if(deq.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(deq.peekLast()+"\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
