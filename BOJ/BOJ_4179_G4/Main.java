package week8.BOJ_4179_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int H, W;
    static char[][] map;
    static int[][] escape_time; // 지훈이가 x,y 에 도달하는 최소 시간
    static int[][] fire_time; // 불이 x,y 에 도달하는 최소시간
    static final int BLOCKED = Integer.MAX_VALUE;
    static List<AbstractMap.SimpleEntry<Integer, Integer>> fire_loc;
    static int start_x;
    static int start_y;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    private static void BFS_escape() {
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(start_x, start_y));
        escape_time[start_x][start_y] = 0; // 시작지점이므로 0
        while (!queue.isEmpty()) {
            int current_x = queue.peek().getKey();
            int current_y = queue.peek().getValue();
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = current_x + dx[i];
                int ny = current_y + dy[i];
                if (isValid(nx, ny, escape_time)) {
                    queue.add(new AbstractMap.SimpleEntry<>(nx, ny));
                    escape_time[nx][ny] = escape_time[current_x][current_y] + 1;
                }
            }
        }
    }

    private static void BFS_fire() {
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        for (AbstractMap.SimpleEntry<Integer, Integer> fire : fire_loc) {
            queue.add(fire);
            fire_time[fire.getKey()][fire.getValue()] = 0; // 불의 초기 위치는 0이다.
        }

        while (!queue.isEmpty()) {
            int current_x = queue.peek().getKey();
            int current_y = queue.peek().getValue();
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = current_x + dx[i];
                int ny = current_y + dy[i];
                if (isValid(nx, ny, fire_time)) {
                    queue.add(new AbstractMap.SimpleEntry<>(nx, ny));
                    fire_time[nx][ny] = fire_time[current_x][current_y] + 1;
                }
            }
        }
    }

    private static boolean isValid(int nx, int ny, int[][] arr) {
        // 좌표가 정상 범위 내이고
        if (0 <= nx && nx < H && 0 <= ny && ny < W) {
            // 그 좌표가 map에서 지나갈 수 있는 공간이면서, arr이 BLOCKED인 경우
            if ((map[nx][ny] == '.' || map[nx][ny] == 'J') && arr[nx][ny] == BLOCKED) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        fire_loc = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                map[i][j] = input[j];
                if (map[i][j] == 'J') {
                    // 지훈이 위치저장
                    start_x = i;
                    start_y = j;
                } else if (map[i][j] == 'F') {
                    // 불붙은 위치 저장
                    fire_loc.add(new AbstractMap.SimpleEntry<>(i, j));
                }
            }
        }

        escape_time = new int[H][W];
        fire_time = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(escape_time[i], BLOCKED);
            Arrays.fill(fire_time[i], BLOCKED);
        }

        // 먼저 현재 map 상태에서 지훈이를 탈출시킨다. 불이 붙지 않는다 가정하고
        BFS_escape();

        // 이후 모든 불의 위치에 대해 BFS을 수행한다.
        BFS_fire();

        // 이제 가장자리 구역만 조사한다.
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if ((i == 0 || i == H - 1) || (j == 0 || j == W - 1)) {
                    if (escape_time[i][j] < fire_time[i][j]) {
                        // 탈출 가능!
                        if (min > escape_time[i][j]) {
                            min = escape_time[i][j];
                        }
                    }
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(min + 1);
        }


    }


}
