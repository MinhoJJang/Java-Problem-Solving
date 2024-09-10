/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16948                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16948                          #+#        #+#      #+#    */
/*   Solved: 2024/09/10 13:20:48 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static final int[] dx = new int[] { -2, -2, 0, 0, +2, +2 };
    static final int[] dy = new int[] { -1, +1, -2, +2, -1, +1 };

    static class Cord {
        int r;
        int c;

        public Cord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], -1);
        }

        Queue<Cord> queue = new LinkedList<>();
        Cord start = new Cord(r1, c1);
        queue.add(start);
        map[r1][c1] = 0;

        while (!queue.isEmpty()) {
            Cord cur = queue.poll();
            int cx = cur.r;
            int cy = cur.c;

            if (cx == r2 && cy == c2)
                break;

            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (map[nx][ny] != -1)
                    continue;

                Cord next = new Cord(nx, ny);
                map[nx][ny] = map[cx][cy] + 1;
                queue.add(next);
            }
        }

        System.out.println(map[r2][c2]);

    }
}