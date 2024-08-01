package week7.BOJ_11724_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int VISITED = 1;

    public static void main(String[] args) throws IOException {
        int N, M, u, v;
        int[] vis;
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        vis = new int[N+1]; // 노드 개수 저장
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arr.add(new AbstractMap.SimpleEntry<>(u, v));
            arr.add(new AbstractMap.SimpleEntry<>(v, u));
        }

        // ArrayList를 순회한다.
        for (AbstractMap.SimpleEntry<Integer, Integer> e : arr) {

            int a = e.getKey();
            int b = e.getValue();

            // 만약 e의 key, value가 이미 방문했던 노드라면 패스
            if (vis[a] == VISITED && vis[b] == VISITED) continue;

            // 새로운 시작점이다! 새로운 시작점이므로 큐에 넣고 방문 표시를 넣어주자
            vis[a] = VISITED;
            vis[b] = VISITED;
            queue.add(a);
            queue.add(b);

            // 근데 이렇게하면 같은 노드에 대해 큐를 여러번 삽입하게 되니 시간낭비가 된다.
            // 처음 방문하는 노드만 큐에 넣어주자
            // 아니다 어차피 하나만 방문하고 하나는 방문하지 않은 경우의 수는 존재하지 않는다
            // 왜? 아래 큐에서 전부 작업할테니까

            while (!queue.isEmpty()){
                int start = queue.poll();
                // 이제 이 start 점이, 내 근처 노드를 찾는 작업이다.
                // 따라서 ArrayList 중에서 start가 포함되어 있는 좌표를 모두 찾는다.
                // 나는 무방향으로 했으니, start가 1이라면 key가 1인 점에 대해서만 찾으면 된다.
                // 그리고 그 찾은 좌표에 대해서, value가 방문하지 않은 상태여야 한다.
                // 그 value에 대해서 visited 해주고 큐에 넣어준다.

                // 뭔가 여기가 사실 굳이 싶은 작업인데 너무 비효율적인것같다.
                for(AbstractMap.SimpleEntry<Integer, Integer> conn : arr){
                    if(conn.getKey() == start){
                        int value = conn.getValue();
                        if(vis[value] != VISITED){
                            vis[value] = VISITED;
                            queue.add(value);
                        }
                    }
                }
            }

            cnt ++;
        }

        System.out.println(cnt);
    }
}
