package BOJ_11657_G4;

import java.io.*;
import java.util.*;

public class Main {

    /*
        if there is a loop, -1
     */
    static final int INF = Integer.MAX_VALUE;
    static final int LOOP = -1;

    static class Edge {
        int start;
        int dest;
        int weight;

        public Edge(int start, int dest, int weight) {
            this.start = start;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] distance_from_city1 = new long[N + 1];
        Arrays.fill(distance_from_city1, INF);
        distance_from_city1[1] = 0;
        ArrayList<Edge> graph = new ArrayList<>();

        boolean is_loop = false;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.add(new Edge(A, B, C));
        }

        for (int i = 1; i <= N; i++) {
            for (Edge e : graph) {
                int A = e.start;
                int B = e.dest;
                int C = e.weight;

                if (distance_from_city1[A] == INF) continue;
                distance_from_city1[B] = Math.min(distance_from_city1[B], distance_from_city1[A] + C);
            }
        }

        for (Edge e : graph) {
            int A = e.start;
            int B = e.dest;
            int C = e.weight;

            if (distance_from_city1[A] == INF) continue;
            if (distance_from_city1[B] > distance_from_city1[A] + C) {
                is_loop = true;
                break;
            }
        }

        if (is_loop) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance_from_city1[i] == INF) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(distance_from_city1[i] + "\n");
                }
            }
            bw.flush();
        }
    }
}
