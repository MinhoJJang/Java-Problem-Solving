package week7.BOJ_1012_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int VISITED = 1;
    final static int LOCATED = 1;

    static int M, N, K;

    static int[][] loc;
    static int[][] vis;
    static Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
    final static int[] dir_x = new int[]{-1, 0, 1, 0};
    final static int[] dir_y = new int[]{0, 1, 0, -1};

    public static void BFS() {

        // 큐가 비었다면 종료한다.
        while (!queue.isEmpty()) {

            // 큐에서 좌표를 꺼내 x,y에 담는다.
            AbstractMap.SimpleEntry<Integer, Integer> next = queue.poll();
            int x = next.getKey();
            int y = next.getValue();

            /*
            이 코드가 바로 메모리초과의 범인

            // 이 배추는 방문한 배추이다.
            vis[x][y] = VISITED;
            */

            for (int dir = 0; dir < 4; dir++) {
                // 현재 좌표에서 상하좌우 위치
                int new_x = x + dir_x[dir];
                int new_y = y + dir_y[dir];

                // 상하좌우 위치가 배열에서 유효한지 확인
                if (new_x < 0 || new_x >= M || new_y < 0 || new_y >= N) continue;

                // 지금 방문하려는 곳이 배추가 없거나, 이미 방문했던 위치라면 패스
                if (loc[new_x][new_y] != LOCATED || vis[new_x][new_y] == VISITED) continue;

                // 이 배추는 방문한 배추이다.
                vis[new_x][new_y] = VISITED;

                // 새 배추다! 큐에 넣어주자
                queue.add(new AbstractMap.SimpleEntry<>(new_x, new_y));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {

            // 배추밭 가로, 세로, 배추개수, 지렁이수
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int cnt = 0;

            // 배추 위치 배열, 배추 방문 배열 생성
            loc = new int[M][N];
            vis = new int[M][N];

            // 배추 위치를 loc에 삽입
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                loc[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = LOCATED;
            }

            // N,M 위치에 대해 순서대로 탐색한다.
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    // 현재 위치 배추 여부 및 현재 위치 방문 여부
                    int cur_loc = loc[x][y];
                    int cur_vis = vis[x][y];

                    // 만약 현재 위치에 배추가 있고 이전에 방문하지 않았다면
                    if (cur_loc == LOCATED && cur_vis != VISITED) {
                        // 배추흰지렁이 한마리 추가
                        cnt++;

                        // 해당 위치에서 BFS로 탐색한다. 큐를 청소하고 새 값을 넣어준다.
                        queue.clear();
                        queue.add(new AbstractMap.SimpleEntry<>(x, y));
                        vis[x][y] = VISITED;
                        BFS();
                    }
                }
            }

            System.out.println(cnt);
        }

    }
}
