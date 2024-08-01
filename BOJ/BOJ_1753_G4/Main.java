package BOJ_1753_G4;

import java.io.*;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // number of Vertexes
        int E = Integer.parseInt(st.nextToken()); // number of Edges
        int start = Integer.parseInt(br.readLine()); // starting point

        PriorityQueue<Path> pq = new PriorityQueue<>(new WeightComparator());
        ArrayList<ArrayList<Path>> adj = new ArrayList<>(V + 2);
        int[] dist = new int[V + 1];

        // Initialize Variables
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Path(start, 0));

        // Input Values
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Path path = new Path(v, w);
            adj.get(u).add(path);
        }

        while (!pq.isEmpty()) {
            Path curPath = pq.poll();
            int curNode = curPath.node;
            int curWeight = curPath.weight;

            // 이미 dist[curNode] 로 가는 최소 비용이 curWeight보다 작다면, 현재 조사하는 경로가 좋지 않은 선택이라는 사실은 자명하다.
            // 따라서 해당 경우에는 조사할 가치가 없으므로 continue 해준다.
            if (dist[curNode] < curWeight) continue;

            for (Path nextPath : adj.get(curNode)) {
                int nextNode = nextPath.node;
                int nextWeight = nextPath.weight;

                // 현재 노드까지의 최소비용 + 다음 노드로의 비용이, 현재까지 계산된 다음 노드로의 비용보다 작다면 이는 최소경로이므로 업데이트해준다.
                if (dist[curNode] + nextWeight < dist[nextNode]) {
                    dist[nextNode] = dist[curNode] + nextWeight;
                    pq.add(new Path(nextNode, dist[nextNode])); // 해당 노드까지 가는 데 드는 최소 비용이 dist[nextNode] 이다.
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                bw.write("INF" + "\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
    }
}
