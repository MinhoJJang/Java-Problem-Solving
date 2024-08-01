package week7.BOJ_11724_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static final int VISITED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 이런게 있다고??
            // 이게 인접 리스트구나..........!!!!!!!!!
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cnt = 0;
        int[] vis = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (vis[i] == VISITED) continue;

            queue.add(i);
            vis[i] = VISITED;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (vis[neighbor] != VISITED) {
                        vis[neighbor] = VISITED;
                        queue.add(neighbor);
                    }
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
