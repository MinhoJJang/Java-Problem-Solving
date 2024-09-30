/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 24479                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/24479                          #+#        #+#      #+#    */
/*   Solved: 2024/09/22 00:16:42 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] visited = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(graph, visited, R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    static int idx = 1;

    static void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int R) {
        visited[R] = idx++;
        for (int i : graph.get(R)) {
            if (visited[i] == 0) {
                dfs(graph, visited, i);
            }
        }
    }
}