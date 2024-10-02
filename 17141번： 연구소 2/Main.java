/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17141                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17141                          #+#        #+#      #+#    */
/*   Solved: 2024/10/01 15:04:58 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dist;
    static int M;
    static ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Point> virusPoints = new ArrayList<>();

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if (k == 2)
                    virusPoints.add(new Point(i, j));
            }
        }

        int virusPoints_count = virusPoints.size();
        ArrayList<Integer> virus_list = new ArrayList<>();

        permutation(virusPoints_count, virus_list, 1);
        int answer = 2000;

        for (ArrayList<Integer> virus_loc : combinations) {
            Queue<Point> queue = new LinkedList<>();
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], -1);
            }
            int max = 0;

            for (Integer i = 1; i <= virusPoints_count; i++) {
                int x = virusPoints.get(i - 1).x;
                int y = virusPoints.get(i - 1).y;
                if (virus_loc.contains(i)) {
                    queue.add(virusPoints.get(i - 1));
                    dist[x][y] = 0;
                }
            }

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (map[i][j] == 1)
                        dist[i][j] = -2;
                }
            }

            while (!queue.isEmpty()) {
                Point cp = queue.poll();
                int cx = cp.x;
                int cy = cp.y;

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;
                    if (map[nx][ny] == 1)
                        continue;
                    if (dist[nx][ny] != -1)
                        continue;

                    dist[nx][ny] = dist[cx][cy] + 1;
                    queue.add(new Point(nx, ny));
                    max = Math.max(dist[nx][ny], max);
                }
            }

            // 만약 모든 점이 방문했다면 dist[][] 에 -1이 없을 것이다.
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][j] == -1) {
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    break;
            }

            if (flag) {
                answer = Math.min(answer, max);
            }
        }

        if (answer == 2000) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }

    static void permutation(int virusPoints_count, ArrayList<Integer> list, int start) {

        if (list.size() == M) {
            combinations.add(new ArrayList<>(list));
            return;
        }

        for (Integer i = start; i <= virusPoints_count; i++) {
            list.add(i);
            permutation(virusPoints_count, list, i + 1);
            list.remove(list.size() - 1);
        }

    }

}