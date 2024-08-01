package week7.BOJ_2606_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static Queue<Integer> queue;
    static int[] visited;
    static final int VISITED = 1;
    static int cnt = 0;

    private static void BFS() {
        while (!queue.isEmpty()) {
            int current_node = queue.poll();
            for (int next : graph.get(current_node)) {
                if (visited[next] != VISITED) {
                    queue.add(next);
                    visited[next] = VISITED;
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 연결 쌍 수
        int u, v;
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        queue = new LinkedList<>();
        queue.add(1);
        visited = new int[N + 1];
        visited[1] = VISITED;
        BFS();
        System.out.println(cnt);
    }
}
