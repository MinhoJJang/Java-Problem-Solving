//package BOJ_10129_G4;

import java.io.*;
import java.util.*;

public class Main {

    static final int A_IS_BIGGER_THAN_B = 1;
    static final int B_IS_SMALLER_THAN_A = -1;
    static final int CONNECTED = 100; 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] answer = new int[N+1];
        int[][] graph = new int[N+1][N+1];
        int[][] connected = new int[N+1][N+1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A][B] = A_IS_BIGGER_THAN_B;
            graph[B][A] = B_IS_SMALLER_THAN_A;
        }

        for (int item = 1; item <= N; item++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(item);

            while (!queue.isEmpty()) {
                int A = queue.poll();
                int next = -1;
                for(int status : graph[A]){
                    next++;
                    if(status == A_IS_BIGGER_THAN_B && connected[item][next] != CONNECTED){
                        connected[item][next] = CONNECTED;
                        queue.add(next);
                        answer[item]++;
                    }
                }
            }
        }

        connected = new int[N+1][N+1];

        for (int item = 1; item <= N; item++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(item);

            while (!queue.isEmpty()) {
                int A = queue.poll();
                for (int next = 1; next <= N; next++) {
                    if(graph[A][next] == B_IS_SMALLER_THAN_A && connected[item][next] != CONNECTED){
                        connected[item][next] = CONNECTED;
                        queue.add(next);
                        answer[item]++;
                    }
                }    
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(N - answer[i] - 1);
        }
    }
}
