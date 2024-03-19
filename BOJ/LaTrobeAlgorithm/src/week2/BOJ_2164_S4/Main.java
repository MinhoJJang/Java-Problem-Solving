package week2.BOJ_2164_S4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int order = 0;
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            deq.offer(i+1);
        }

        while(deq.size() != 1){
            if(order++ % 2 == 0){
                deq.remove();
            }
            else{
                deq.offer(deq.pollFirst());
            }
        }
        System.out.println(deq.poll());
    }
}
