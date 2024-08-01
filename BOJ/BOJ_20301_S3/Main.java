package week2.BOJ_20301_S3;

import java.util.*;

public class Main {

    static final int left = -1;
    static final int right = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();

        int removedPeopleCount = 0;
        int direction = left;

        for (int i = 0; i < N; i++) {
            deq.offer(i+1);
        }

        for (int i = 0; i < N; i++) {

            if(removedPeopleCount % M == 0){
                direction = -direction;
                removedPeopleCount = 0;
            }

            if(direction == right){
                for (int j = 0; j < K-1; j++) {
                    deq.offerLast(deq.pollFirst());
                }
                sb.append(deq.pollFirst()+"\n");
                removedPeopleCount++;
            }
            else {
                for (int j = 0; j < K-1; j++) {
                    deq.offerFirst(deq.pollLast());
                }
                sb.append(deq.pollLast()+"\n");
                removedPeopleCount++;
            }
        }

        System.out.println(sb);
    }
}
