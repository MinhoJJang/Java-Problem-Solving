/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14284                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14284                          #+#        #+#      #+#    */
/*   Solved: 2024/09/10 14:39:27 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        long weight;
        int point;

        public Edge(long weight, int point) {
            this.weight = weight;
            this.point = point;
        }

        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.weight, other.weight); // Compare edges by weight
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        long[] visited = new long[n + 1];

        Arrays.fill(visited, Long.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(c, b));
            graph.get(b).add(new Edge(c, a));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        visited[start] = 0;
        queue.add(new Edge(0l, start));

        while (!queue.isEmpty()) {
            Edge ce = queue.poll();
            int cur = ce.point;
            long weight = ce.weight;

            if (cur == end)
                break;

            for (Edge next : graph.get(cur)) {
                int next_point = next.point;
                long next_weight = next.weight;

                if (visited[next_point] <= weight + next_weight)
                    continue;

                visited[next_point] = weight + next_weight;
                queue.add(new Edge(visited[next_point], next_point));
            }
        }

        System.out.println(visited[end]);
    }
}