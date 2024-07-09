package week11.BOJ_7562_S1;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int INIT = 183759;

    static int[] dir_x = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dir_y = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(map[i], INIT);
            }

            Queue<Point> queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            Point startingPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point targetPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            queue.add(startingPoint);

            map[startingPoint.x][startingPoint.y] = 0;

            // 시작, 도착점 같을 경우 체크
            if (startingPoint.x == targetPoint.x && startingPoint.y == targetPoint.y) {
                bw.write(0 + "\n");
                continue;
            }

            while (!queue.isEmpty()) {
                Point curPoint = queue.poll();
                int cx = curPoint.x;
                int cy = curPoint.y;

                if (targetPoint.x == cx && targetPoint.y == cy) {
                    bw.write(map[cx][cy] + "\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = dir_x[i] + cx;
                    int ny = dir_y[i] + cy;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] != INIT) continue;

                    queue.add(new Point(nx, ny));
                    map[nx][ny] = map[cx][cy] + 1;
                }
            }
        }

        bw.flush();
    }
}
