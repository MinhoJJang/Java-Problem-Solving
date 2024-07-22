//package BOJ_1865_G3;

import java.io.*;
import java.util.*;

public class Main2 {

    static class Edge {
        int start;
        int end; 
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        long INF = 499 * 2500 * 100000 + 1;

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            // 그래프를 인접 리스트로 표현
            ArrayList<Edge> edges = new ArrayList<>();
            ArrayList<Integer> hole_target = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                // 도로는 무방향 그래프
                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                // 웜홀은 방향 그래프
                edges.add(new Edge(S, E, -T));
                // if(!hole_target.contains(E)){
                //     hole_target.add(E);
                // }

                hole_target.add(E);
            }

            // 벨만-포드 알고리즘을 통해 음의 가중치 순환을 감지
            boolean hasNegativeCycle = false;
            long[] dist = new long[N + 1];

            for (int i : hole_target) {
                Arrays.fill(dist, INF);
                dist[i] = 0;
    
                // N-1번 반복
                for (int j = 1; j < N; j++) {
                    for (Edge edge : edges) {
                       // if (dist[edge.start] != INF) {
                            dist[edge.end] = Math.min(dist[edge.start] + edge.weight, dist[edge.end]);
                       // }
                    }
                }
    
                // N번째 반복에서 값이 갱신되면 음의 가중치 순환이 존재
                for (Edge edge : edges) {
                    if (dist[edge.start] != INF && dist[edge.start] + edge.weight < dist[edge.end]) {
                        hasNegativeCycle = true;
                    }
                }
                
                if(hasNegativeCycle) break;
            }
           
            if (hasNegativeCycle) {
                answer.append("YES\n");
            } else {
                answer.append("NO\n");
            }
        }
        System.out.println(answer);
    }

}