package week5.BOJ_9184_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static int[][][] memo;
    static int init = -1;


    static String formatter(int[] numbers) {
        return "w(" + numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ") = ";
    }

    static int wABC(int a, int b, int c) {
        // 일단 먼저 음수를 거른다. BufferUnderflow가 발생하기때문
        if (a <= 0 || b <= 0 || c <= 0) {
            return memo[0][0][0];
        } else {
            if (memo[a][b][c] == init) {
                if (a > 20 || b > 20 || c > 20) {
                    if (memo[20][20][20] == init) {
                        memo[20][20][20] = wABC(20, 20, 20);
                    }
                    memo[a][b][c] = memo[20][20][20];
                } else if (a < b && b < c) {
                    if (memo[a][b][c - 1] == init) {
                        memo[a][b][c - 1] = wABC(a, b, c - 1);
                    }
                    if (memo[a][b - 1][c - 1] == init) {
                        memo[a][b - 1][c - 1] = wABC(a, b - 1, c - 1);
                    }
                    if (memo[a][b - 1][c] == init) {
                        memo[a][b - 1][c] = wABC(a, b - 1, c);
                    }
                    memo[a][b][c] = memo[a][b][c - 1] + memo[a][b - 1][c - 1] - memo[a][b - 1][c];
                } else {
                    if (memo[a - 1][b][c] == init) {
                        memo[a - 1][b][c] = wABC(a - 1, b, c);
                    }
                    if (memo[a - 1][b - 1][c] == init) {
                        memo[a - 1][b - 1][c] = wABC(a - 1, b - 1, c);
                    }
                    if (memo[a - 1][b][c - 1] == init) {
                        memo[a - 1][b][c - 1] = wABC(a - 1, b, c - 1);
                    }
                    if (memo[a - 1][b - 1][c - 1] == init) {
                        memo[a - 1][b - 1][c - 1] = wABC(a - 1, b - 1, c - 1);
                    }
                    memo[a][b][c] = memo[a - 1][b][c] + memo[a - 1][b - 1][c] + memo[a - 1][b][c - 1] - memo[a - 1][b - 1][c - 1];
                }
            }
            return memo[a][b][c];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        memo = new int[51][51][51];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                Arrays.fill(memo[i][j], init);
            }
        }
        int[] numbers = new int[3];
        memo[0][0][0] = 1;

        while (!(s = br.readLine()).equals("-1 -1 -1")) {
            String[] input = s.split(" ");
            for (int i = 0; i < 3; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            System.out.println(formatter(numbers) + wABC(numbers[0], numbers[1], numbers[2]));
        }
    }
}
