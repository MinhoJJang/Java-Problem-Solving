/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11909                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11909                          #+#        #+#      #+#    */
/*   Solved: 2024/10/08 17:47:31 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static final int INIT = 100000000;
    static int[][] map;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], INIT);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 0;
        System.out.println(findLowestCost(n, n));
    }

    static int findLowestCost(int x, int y) {
        if (x == 2 && y == 1 || x == 1 && y == 2) {
            dp[x][y] = dp[1][1] + buttonCountFromTo(map[1][1], map[x][y]);
        } else {
            int[] pxs = { x, x - 1 };
            int[] pys = { y - 1, y };

            for (int i = 0; i < 2; i++) {
                int px = pxs[i];
                int py = pys[i];

                if (px < 1 || px > n || py < 1 || py > n)
                    continue;
                if (dp[px][py] == INIT)
                    findLowestCost(px, py);
                dp[x][y] = Math.min(dp[x][y], dp[px][py] + buttonCountFromTo(map[px][py], map[x][y]));
            }
        }

        return dp[x][y];
    }

    static int buttonCountFromTo(int from, int to) {
        return Math.max(to - from + 1, 0);
    }
}