package week8.BOJ_16236_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] sea;
    static final int BLOCKED = Integer.MAX_VALUE;
    static int total_time = 0;
    static int eat_cnt = 0;
    static int start_x;
    static int start_y;
    static int shark_size = 2;
    static List<AbstractMap.SimpleEntry<Integer, Integer>> fish_list;
    static int N;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    private static void BFS(int baby_shark, int start_x, int start_y) {

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], BLOCKED);
        }

        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(start_x, start_y));
        map[start_x][start_y] = 0;

        while (!queue.isEmpty()) {
            int cx = queue.peek().getKey();
            int cy = queue.peek().getValue();
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isValid(nx, ny, map)) {
                    queue.add(new AbstractMap.SimpleEntry<>(nx, ny));
                    map[nx][ny] = map[cx][cy] + 1;
                }
            }
        }

        if (fish_list.size() == 0) {
            return;
        }

        int min = Integer.MAX_VALUE;
        int sx = N - 1;
        int sy = N - 1;

        for (AbstractMap.SimpleEntry<Integer, Integer> fish : fish_list) {
            int fx = fish.getKey();
            int fy = fish.getValue();

            if (min > map[fx][fy]) {
                sx = fx;
                sy = fy;
                min = map[fx][fy];
            } else if (min == map[fx][fy]) {
                // 상단, 좌측에 있는 물고기부터
                if (fx < sx || (fx == sx && fy < sy)) {
                    // 상단, 왼쪽에 있는 물고기면 일단 그놈부터 먹는다
                    sx = fx;
                    sy = fy;
                }
            }
        }

        // 먹을 물고기를 찾았다. 물고기를 먹자
        eat_cnt++;
        total_time += min;
        sea[sx][sy] = 0;
        fish_list.remove(new AbstractMap.SimpleEntry<>(sx, sy));
        if (shark_size == eat_cnt) {
            eat_cnt = 0;
            shark_size++;
        }
        BFS(shark_size, sx, sy);
    }

    private static boolean isValid(int nx, int ny, int[][] map) {
        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            if (map[nx][ny] == BLOCKED && sea[nx][ny] <= shark_size) {
                if (sea[nx][ny] < shark_size && sea[nx][ny] != 0 && !fish_list.contains(new AbstractMap.SimpleEntry<>(nx, ny))) {
                    fish_list.add(new AbstractMap.SimpleEntry<>(nx, ny));
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sea = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    // 상어 초기 위치
                    start_x = i;
                    start_y = j;
                    sea[i][j] = 0; // 문제 실수 .. 이걸 안해주면 상어 초기위치를 못지나간다
                }
            }
        }
        fish_list = new ArrayList<>();
        BFS(shark_size, start_x, start_y);

        System.out.println(total_time);
    }
}
