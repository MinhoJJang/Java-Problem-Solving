/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11265                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11265                          #+#        #+#      #+#    */
/*   Solved: 2024/10/08 15:57:57 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.util.*;
import java.io.*;

public class Main {

    static final int INIT = Integer.MAX_VALUE;
    static final String ENJOY = "Enjoy other party";
    static final String STAY = "Stay here";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] != INIT && map[k][j] != INIT) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (map[A][B] <= C)
                bw.append(ENJOY + "\n");
            else
                bw.append(STAY + "\n");
        }

        bw.flush();
    }
}