package week10.BOJ_6479_G4;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // Testcase 동안 계속 loop
        while (true) {
            ArrayList<Map<Integer, Integer>> graph;
            boolean[] visited;
            PriorityQueue<Map.Entry<Integer, Integer>> pq;
            int result = 0;
            int max_value = 0;

            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (V == 0 && E == 0) {
                break;
            }

            // 그래프 초기화
            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new HashMap<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                max_value += value;

                graph.get(u).put(v, value);
                graph.get(v).put(u, value);
            }

            // PriorityQueue를 가중치 기준으로 정렬되도록 생성
            pq = new PriorityQueue<>(Map.Entry.comparingByValue());

            // 방문 배열 초기화
            visited = new boolean[V + 1];

            // 0번을 가장 먼저 방문한다.
            visit(0, visited, pq, graph);

            // pq가 빌 때 까지
            while (!pq.isEmpty()) {
                Map.Entry<Integer, Integer> edge = pq.poll();
                int vertex = edge.getKey();
                int weight = edge.getValue();

                // 만약 아직 방문하지 않은 노드라면, 추가한다.
                if (!visited[vertex]) {
                    result += weight;
                    visit(vertex, visited, pq, graph);
                }
            }

            bw.write(max_value - result + "\n");
        }
        bw.flush();
    }

    private static void visit(int i, boolean[] visited, PriorityQueue<Map.Entry<Integer, Integer>> pq, ArrayList<Map<Integer, Integer>> graph) {
        visited[i] = true;
        // graph에서 i와 연결된 모든 점을 찾고, pq에 넣는다.
        for (Map.Entry<Integer, Integer> entry : graph.get(i).entrySet()) {
            if (!visited[entry.getKey()]) {
                pq.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
            }
        }
    }
}