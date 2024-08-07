package BOJ_17090;

import java.io.*;
import java.util.*;

public class Answer {

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

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
        return nx < 0 || nx >= N || ny < 0 || ny >= M;
    }

    public static void main(String[] args) throws IOException {

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

                if (memo[i][j] != INIT) continue;

                Stack<Coordinate> stack = new Stack<>();
                Set<Coordinate> visited = new HashSet<>();

                Coordinate start = new Coordinate(i, j);
                stack.push(start);
                visited.add(start);

                boolean canEscape = false;

                while (!stack.isEmpty()) {
                    Coordinate current = stack.peek();
                    int cx = current.x;
                    int cy = current.y;

                    Coordinate next = nextCoordinate(current, dir[cx][cy]);
                    int nx = next.x;
                    int ny = next.y;

                    if (isEscapable(next, N, M)) {
                        canEscape = true;
                        break;
                    }

                    if (memo[nx][ny] != INIT) {
                        canEscape = memo[nx][ny] == ESCAPE;
                        break;
                    }

                    if (visited.contains(next)) {
                        canEscape = false;
                        break;
                    }

                    stack.push(next);
                    visited.add(next);
                }

                while (!stack.isEmpty()) {
                    Coordinate c = stack.pop();
                    int cx = c.x;
                    int cy = c.y;
                    memo[cx][cy] = canEscape ? ESCAPE : NOT_ESCAPE;
                    if (canEscape) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}