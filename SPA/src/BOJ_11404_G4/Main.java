package BOJ_11404_G4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 100000 * (100 - 1) + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(c, dist[a][b]);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF || i == j) continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                /*
                반례:
                만약 1-2 까지 100,000
                    2-3 까지 1 이라면

                    1-3 은 100,001 이다

                    진짜 최악의 경우에도 가능하려면

                    1~100까지 경로가 99개일때, 100,000 * 99이 가능한 최대 값이다.
                 */
                if (dist[i][j] >= INF) {
                    dist[i][j] = 0;
                }
                bw.write(dist[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();

    }
}
