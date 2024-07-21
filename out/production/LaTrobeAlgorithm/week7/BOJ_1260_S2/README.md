# DFS와 BFS
https://www.acmicpc.net/problem/1260

# 풀이

```java
package week7.BOJ_1260_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int VISITED = 1;

    static List<List<Integer>> graph;
    static Queue<Integer> queue;
    static Stack<Integer> stack;
    static int[] visited_BFS;
    static int[] visited_DFS;
    static StringBuilder sb;

    private static void BFS() {
        while (!queue.isEmpty()) {
            int current_node = queue.poll();
            sb.append(current_node + " ");

            // current_node 에서 이동 가능한 노드이고, 방문한 적이 없을 경우
            for (int next : graph.get(current_node)) {
                if (visited_BFS[next] != VISITED) {
                    // 큐에 추가하고 방문 표시를 남긴다
                    queue.add(next);
                    visited_BFS[next] = VISITED;
                }
            }
        }
    }

    private static void DFS() {
        while (!stack.isEmpty()) {
            int current_node = stack.pop();
            sb.append(current_node + " ");
            visited_DFS[current_node] = VISITED;

            for(int next : graph.get(current_node)){
                if(visited_DFS[next] != VISITED){
                    stack.push(next);
                    DFS();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 인접 리스트로 풀이하면 될듯
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, V;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // graph 인접 리스트로 생성
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 그래프 정렬 - 정점 번호가 작은 것부터 방문하기 위해
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }


        // DFS 수행
        visited_DFS = new int[N+1];
        visited_DFS[V] = VISITED;
        stack = new Stack<>();
        stack.push(V);
        sb = new StringBuilder();
        DFS();
        System.out.println(sb);

        // BFS 수행
        visited_BFS = new int[N+1];
        visited_BFS[V] = VISITED;
        queue = new LinkedList<>();
        queue.add(V);
        sb.setLength(0);
        BFS();
        System.out.println(sb);

    }
}

```

# 실수한 부분

1. graph의 내부 List 초기화를 하지 않았음
```java
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
```

2. N+1로 초기화 해야 하는데 N으로 초기화했음
```java
      visited_DFS = new int[N+1];
```

