package week8.BOJ_2636_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int AIR = 0;
    static final int CHEESE = 1;
    static final int ISOLATED = 99; // air, cheese 초기화
    static int H, W;
    static int[][] map; // 입력값 저장하는 map. 1시간마다 업데이트 된다.
    static int[][] air; // 공기만 저장
    static int[][] cheese;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    private static void BFS_air(int x, int y) {
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(x, y));
        air[x][y] = AIR;
        while (!queue.isEmpty()) {
            int current_x = queue.peek().getKey();
            int current_y = queue.peek().getValue();
            queue.remove();
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = current_x + dx[i];
                ny = current_y + dy[i];
                if (isValid(nx, ny)) {
                    queue.add(new AbstractMap.SimpleEntry<>(nx, ny));
                    air[nx][ny] = AIR;
                }
            }
        }
    }

    private static boolean isValid(int nx, int ny) {
        if (0 <= nx && nx < H && 0 <= ny && ny < W) {
            if (air[nx][ny] == ISOLATED) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAir(int nx, int ny) {
        if (0 <= nx && nx < H && 0 <= ny && ny < W) {
            if (air[nx][ny] == AIR) {
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
        map = new int[H][W];
        air = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(air[i], ISOLATED);
        }

        List<AbstractMap.SimpleEntry<Integer, Integer>> cheese_list = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == CHEESE) {
                    cheese_list.add(new AbstractMap.SimpleEntry<>(i, j));
                    air[i][j] = CHEESE;
                }
            }
        }

        // 공기를 BFS로 찾는다.
        BFS_air(0, 0);

        /*
            치즈 배열을 순회한다.
            치즈 위치의 상하좌우를 검사한다.
            해당 상하좌우 위치 중 하나라도 air[][] 에서 AIR로 초기화 되어있다면, 해당 치즈는 녹을 것이다.
            그 녹을 치즈를 cheese_melt 리스트에 저장한다.

            모든 치즈에 대해 검사가 끝나고 cheese_melt 리스트가 완성되면, 아래 작업을 수행한다.
            일단 해당 리스트의 길이를 저장한다.
            만약 cheese_melt에 대해서 맞닿은 부분 중에 ISOLATED가 있다 -> 고립된 위치를 찾은 것이다.
            해당 위치부터 다시 BFS 수행해서 air을 찾는다
         */
        int last_cheese = 0;
        int melt_count = 0;
        while (cheese_list.size() != 0) {
            List<AbstractMap.SimpleEntry<Integer, Integer>> cheese_melt = new ArrayList<>();
            melt_count++;
            for (AbstractMap.SimpleEntry<Integer, Integer> cheese : cheese_list) {
                int x = cheese.getKey();
                int y = cheese.getValue();
                for (int i = 0; i < 4; i++) {
                    // 4방향 중에 하나라도 AIR이 있는지 검사
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (isAir(nx, ny)) {
                        // 녹을 치즈이므로 리스트 추가 후 for문 탈출
                        cheese_melt.add(cheese);
                        break;
                    }
                }
            }
            last_cheese = cheese_melt.size();

            for (AbstractMap.SimpleEntry<Integer, Integer> cheese : cheese_melt) {
                int x = cheese.getKey();
                int y = cheese.getValue();
                BFS_air(x, y);
            }
            cheese_list.removeAll(cheese_melt);
        }

        System.out.println(melt_count);
        System.out.println(last_cheese);
    }


}
