package week10.BOJ_1647_G4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Map<Integer, Integer>> graph;
    static boolean[] visited;
    static PriorityQueue<Map.Entry<Integer, Integer>> pq;
    static int result = 0;
    static int max_weight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

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

            graph.get(u).put(v, value);
            graph.get(v).put(u, value);
        }

        // PriorityQueue를 가중치 기준으로 정렬되도록 생성
        // pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        // 방문 배열 초기화
        visited = new boolean[V + 1];

        // 1번을 가장 먼저 방문한다.
        visit(1);

        // pq가 빌 때 까지
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> edge = pq.poll();
            int vertex = edge.getKey();
            int weight = edge.getValue();

            // 만약 아직 방문하지 않은 노드라면, 추가한다.
            if (!visited[vertex]) {
                result += weight;
                // 내가 추가했던 간선 weight의 최댓값을 저장한다.
                max_weight = max_weight < weight ? weight : max_weight;
                visit(vertex);
            }
        }

        System.out.println(result - max_weight);
    }

    private static void visit(int i) {
        visited[i] = true;
        // graph에서 i와 연결된 모든 점을 찾고, pq에 넣는다.
        for (Map.Entry<Integer, Integer> entry : graph.get(i).entrySet()) {
            if (!visited[entry.getKey()]) {
                pq.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
            }
        }
    }
}
