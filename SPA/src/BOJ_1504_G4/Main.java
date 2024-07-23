package BOJ_1504_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    static class Path {
        int node;
        int weight;

        public Path(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class WeightComparator implements Comparator<Path> {
        @Override
        public int compare(Path o1, Path o2) {
            return Integer.compare(o1.weight, o2.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Path>> graph = new ArrayList<>();
        for (int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Path(b, c));
            graph.get(b).add(new Path(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[][] startNodes = new int[][]{{1, v1, v2}, {1, v2, v1}};
        int[][] targetNodes = new int[][]{{v1, v2, N}, {v2, v1, N}};

        long[] sum = new long[]{0, 0};

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 3; i++) {

                PriorityQueue<Path> pq = new PriorityQueue<>(new WeightComparator());
                int[] dist = new int[N + 1];

                Arrays.fill(dist, INF);

                dist[startNodes[j][i]] = 0;
                pq.add(new Path(startNodes[j][i], 0));

                while (!pq.isEmpty()) {
                    Path p = pq.poll();
                    int curNode = p.node;
                    int curWeight = p.weight;

                    if (dist[curNode] < curWeight) continue;

                    for (Path next : graph.get(curNode)) {
                        if (dist[curNode] + next.weight < dist[next.node]) {
                            dist[next.node] = dist[curNode] + next.weight;
                            pq.add(new Path(next.node, dist[next.node]));
                        }
                    }
                }

                // targetNodes 까지 가는데 최솟값을 저장한다. 만약 이 값이 INF라면 sum은 -1이 될 것이다.
                if (dist[targetNodes[j][i]] == INF) {
                    sum[j] = -1;
                    break;
                } else {
                    sum[j] += dist[targetNodes[j][i]];
                }
            }
        }

        System.out.println(Math.min(sum[0], sum[1]));
    }
}
