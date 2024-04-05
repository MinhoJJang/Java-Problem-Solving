package week5.BOJ_9095_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] memo;
    static int init = -1;

    static int expressNumberWithOneTwoThree(int n) {

        if (memo[n] == init) {
            if (n <= 2) {
                memo[n] = n;
            } else if (n == 3) {
                memo[n] = 4;
                // 3 = 1+1+1  / 1+2 / 2+1 / 3
            } else {
                if (memo[n - 3] == init) {
                    memo[n - 3] = expressNumberWithOneTwoThree(n - 3);
                }
                if (memo[n - 2] == init) {
                    memo[n - 2] = expressNumberWithOneTwoThree(n - 2);
                }
                if (memo[n - 1] == init) {
                    memo[n - 1] = expressNumberWithOneTwoThree(n - 1);
                }
                memo[n] = memo[n - 3] + memo[n - 2] + memo[n - 1];
            }
        }

        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            memo = new int[n + 1];
            Arrays.fill(memo, init);
            System.out.println(expressNumberWithOneTwoThree(n));
        }

    }
}
