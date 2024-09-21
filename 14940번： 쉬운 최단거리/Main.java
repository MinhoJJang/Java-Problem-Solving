/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14940                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14940                          #+#        #+#      #+#    */
/*   Solved: 2024/09/20 19:47:22 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static class Loc {
        int x,y;

        public Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] info = new int[n][m];
        int[][] dist = new int[n][m];

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
                if(info[i][j] == 2){
                    start = i;
                    end = j;
                }
            }
        }

        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(start, end));
        dist[start][end] = 0;

        while (!queue.isEmpty()) {
            Loc curLoc = queue.poll();
            int cx = curLoc.x;
            int cy = curLoc.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(info[nx][ny] != 1) continue;
                if(dist[nx][ny] != 0) continue;

                queue.add(new Loc(nx, ny));
                dist[nx][ny] = dist[cx][cy] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int d = dist[i][j];
                if(d == 0 && info[i][j] == 1) d = -1;
                sb.append(d + " ");
            }
            System.out.println(sb.toString().trim());
            sb.setLength(0);
        }

    }
}