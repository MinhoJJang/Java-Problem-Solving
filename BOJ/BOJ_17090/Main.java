package BOJ_17090;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class Main {

    static final int INIT = 999999;
    static final int ESC = 1;
    static final int NOT_ESC = -1;

    static final char U = 0;

    static Character[] dir = new Character[] {'U', 'R', 'D', 'L'};
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        
        /*
         * 테두리를 먼저 돈다. 
         * 탈출이 가능한 경우 ESCAPBLE 로 초기화
         * 불가능의 경우 NOT ESCAPLE 로 초기화
         * 모르는 경우 DONTKNOW 로 초기화
         * 
         * 해당 위치가탈출가능하면 그 위치로 갈 수 있는 모든 공간이 탈출가능하다.
         * 
         * U = up
         * 
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Character[][] map = new Character[N][M];
        int[][] escape = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(escape[i], INIT);
            char[] next = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = next[j];

                if(i == 0 || j == 0){
                    if(escape[i][j] == INIT){
                        int nx = i + dx[map[i][j].]
                    }
                }
            }

            
        }



    }
}
