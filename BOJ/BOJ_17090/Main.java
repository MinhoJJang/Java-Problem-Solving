//package BOJ_17090;

import java.io.*;
import java.util.*;

        /*
         * map을 순회한다. 
         * 
         * 만약 escape[cx][cy] != INIT 이라면 이미 조사한 곳이므로 패스
         * cx, cy를 스택에 넣는다.
         * 
         * loop: stack이 빌 때 까지
         * 
         * cx, cy는 stack의 가장 위에 있다. 
         * 현재 위치(cx, cy) 에서 방향을 보고 갈 수 있는 다음 위치를 nx, ny라 하자.
         * 
         * nx, ny가 맵을 벗어날 경우, 탈출가능한 곳이다. 스택의 모든 위치를 ESCAPE로 초기화한다. 
         * 
         * 만약 맵을 벗어나지 않고 escape[nx][ny] != INIT 이라면 스택에 있던 모든 위치를 escape[nx][ny] 로 초기화한다.
         * 
         * 맵을 벗어나지 않고 escape[nx][ny] 도 INIT 이라면 나는 더 조사를 해야 한다. 
         * - 이때 nx ny가 스택에 이미 존재할경우, 지금 나는 루프가 생성된 것이다. 
         * - 즉시 스택의 모든 위치를 NO_ESCAPE 로 초기화한다. 
         * 
         * 스택에 존재하지 않는다면, nx, ny를 스택에 넣는다.
         * 
         */

public class Main {

    static final int INIT = 0;
    static final int ESCAPE = 1;
    static final int NOT_ESCAPE = -1;

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate c = (Coordinate) o;
            return x == c.x && y == c.y;
        }
    }

    static Coordinate nextCoordinate(Coordinate c, char dir){

        int nx = c.x;
        int ny = c.y;

        switch (dir) {
            case 'U':
                nx--;
                break;
            case 'R':
                ny++;
                break;
            case 'D':
                nx++;
                break;
            case 'L':
                ny--;
                break;
        }

        return new Coordinate(nx, ny);
    }

    static boolean isEscapable(Coordinate c, int N, int M){
        int nx = c.x;
        int ny = c.y;
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) return true;
        return false;
    }
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        char[][] dir = new char[N][M];
        int[][] memo = new int[N][M];
        
        // map 값 받기
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                dir[i][j] = input[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                
                if(memo[i][j] != INIT) continue;

                Stack<Coordinate> stack = new Stack<>();
                HashSet<Coordinate> hs = new HashSet<>();

                Coordinate k = new Coordinate(i, j);
                
                stack.push(k);
                hs.add(k);

                while(!stack.isEmpty()){
                    Coordinate c = stack.peek();
                    int cx = c.x;
                    int cy = c.y;

                    Coordinate cn = nextCoordinate(c, dir[cx][cy]);
                    int nx = cn.x;
                    int ny = cn.y;

                    if(hs.contains(cn)){
                        while (!stack.isEmpty()) {
                            Coordinate nc = stack.pop();
                            memo[nc.x][nc.y] = NOT_ESCAPE;
                        }
                        break;
                    }
                    
                    if(isEscapable(cn, N, M)){
                        answer += stack.size();
                        while (!stack.isEmpty()) {
                            Coordinate nc = stack.pop();
                            memo[nc.x][nc.y] = ESCAPE;
                        }
                        break;
                    }
                    else{
                        int type = memo[nx][ny];
                        if(type != INIT){
                            if(type == ESCAPE) answer += stack.size();
                            while (!stack.isEmpty()) {
                                Coordinate nc = stack.pop();
                                memo[nc.x][nc.y] = type;
                            }
                            break;
                        }
                    }

                    stack.push(cn);
                    hs.add(cn);
                }
                
            }
        }

        System.out.println(answer);


    }
}
