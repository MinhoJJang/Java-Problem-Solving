package week8.BOJ_2589_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int H, W; // 세로, 가로
    static char[][] map;// 보물지도
    static int[][][][] visit; // 보물지도 특정 위치 방문 여부
    // 이때 특이한 점은 4차원이다
    // 즉, 시작 point에 따라 다른 visit 배열을 만든다는 것이다. start -> next
    static final int VISITED = 1;
    static Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[][][][] time; // 특정 위치 x,y 육지에서 가장 먼 곳까지 가는 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visit = new int[H][W][H][W];
        queue = new LinkedList<>();
        time = new int[H][W][H][W];
        int[][] max_time = new int[H][W];

        char[] input;
        for (int i = 0; i < H; i++) {
            input = br.readLine().toCharArray();
            map[i] = Arrays.copyOf(input, W);
        }

        // BFS 탐색 시작. 가장 먼저, 육지의 리스트를 만든다.

        /*
        모든 칸에 대해서 육지의 가능성을 열어두고 조사한다.

        1. 만약 육지가 아니라면 패스
        2. 만약 육지인데, 방문했었다면 패스

        3. 1,2 둘다 해당 안된다면, 처음 방문하는 육지이다. 따라서 BFS를 수행한다.
        */
        for (int start_x = 0; start_x < H; start_x++) {
            for (int start_y = 0; start_y < W; start_y++) {
                if (map[start_x][start_y] == 'L') {

                    queue.add(new AbstractMap.SimpleEntry<>(start_x, start_y));
                    visit[start_x][start_y][start_x][start_y] = VISITED;
                    time[start_x][start_y][start_x][start_y] = 0;

                    int max = 0; // max 초기화 // 이걸 안넣어줘서...........하...

                    while (!queue.isEmpty()) {
                        AbstractMap.SimpleEntry<Integer, Integer> current = queue.poll();
                        int current_x = current.getKey();
                        int current_y = current.getValue();

                        for (int k = 0; k < 4; k++) {
                            int nx = current_x + dx[k];
                            int ny = current_y + dy[k];
                            if (isValid(new AbstractMap.SimpleEntry<>(nx, ny), start_x, start_y)) {
                                queue.add(new AbstractMap.SimpleEntry<>(nx, ny));
                                visit[start_x][start_y][nx][ny] = VISITED;
                                time[start_x][start_y][nx][ny] = time[start_x][start_y][current_x][current_y] + 1;
                                if (max < time[start_x][start_y][nx][ny]) {
                                    max = time[start_x][start_y][nx][ny];
                                }
                            }
                        }
                    }
                    max_time[start_x][start_y] = max; // 해당 위치에서의 BFS 종료 후 최대 거리를 저장
                }
            }
        }

        /*
         예외 케이스가 있을 수 있다.
         만약에 육지가 단 1개라면? 그런건 안주겠지;
         */

        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (max < max_time[i][j]) {
                    max = max_time[i][j];
                }
            }
        }

        System.out.println(max);
    }

    private static boolean isValid(AbstractMap.SimpleEntry<Integer, Integer> next, int start_x, int start_y) {
        int nx = next.getKey();
        int ny = next.getValue();

        // x,y 좌표가 정상범위이고, 해당 좌표를 i,j에서 x,y로 방문한 적이 없으며, 육지인 경우에만 true 리턴
        if (0 <= nx && nx < H && 0 <= ny && ny < W) {
            if (visit[start_x][start_y][nx][ny] != VISITED && map[nx][ny] == 'L') {
                return true;
            }
        }
        return false;
    }
}
