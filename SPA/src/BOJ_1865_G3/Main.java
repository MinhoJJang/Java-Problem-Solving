//package BOJ_1865_G3;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        long INF = Long.MAX_VALUE;
        int AVAILABLE = 1;

        while (TC-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int S, E, T;
            int flag = -AVAILABLE;
            // 가능한 최대 거리가 124억을 넘기 때문에 long 배열로 선언한다.
            long[][] dist = new long[N+1][N+1];

            // 거리 저장 배열을 INF 으로 초기화시킨다. 
            // 어떤 지점 사이 거리가 INF 이면 해당 지점으로 가는 도로가 없다는 뜻이다.
            for (int i = 0; i < N+1; i++) {
                Arrays.fill(dist[i], INF);
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                
                // 두 지점을 연결하는 도로가 한 개 이상일 경우, 가장 시간이 적게 걸리는 도로만 선택한다.
                // 도로는 방향이 없다. 
                dist[S][E] = Math.min(dist[S][E], T);
                dist[E][S] = dist[S][E];
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                
                // 두 지점을 연결하는 웜홀이 한 개 이상일 경우, 가장 시간이 적게 걸리는 웜홀만 선택한다.
                // 웜홀은 방향이 존재한다.
                // 웜홀은 시간이 거꾸로 가므로 시간에 -T 를 넣어준다. 
                dist[S][E] = Math.min(dist[S][E], -T);
            }
            
            // 모든 dist[i][j] 에 대해 최솟값을 구한다.
            for (int k = 1; k <= N; k++) {
                for (int i= 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if(dist[i][k] == INF || dist[k][j] == INF) continue;
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            // dist[i][k] + dist[k][i] 가 0보다 작은 경우가 있는지 찾는다.
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(dist[i][j] + dist[j][i] < 0){
                        // 시간이 되돌아가는 경우가 존재한다! 
                        flag = AVAILABLE;
                    }
                }
            }

            if(flag == AVAILABLE){
                answer.append("YES\n");
            }
            else {
                answer.append("NO\n");
            }
        }
        System.out.println(answer);
    }

}
