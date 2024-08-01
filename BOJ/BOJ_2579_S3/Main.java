package week5.BOJ_2579_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] value;
    static int[] memo;
    static final int init = -1;

    static int findMax(int n) {
        if (memo[n] == init) {
            if (n == 1) {
                memo[n] = value[1];
            } else if (n == 2) {
                memo[n] = value[1] + value[2];
            } else if (n == 3) {
                memo[n] = Math.max(value[1] + value[3], value[2] + value[3]);
            } else {
                if (memo[n - 3] == init) {
                    memo[n - 3] = findMax(n - 3);
                }
                if (memo[n - 2] == init) {
                    memo[n - 2] = findMax(n - 2);
                }
                if (memo[n - 1] == init) {
                    memo[n - 1] = findMax(n - 1);
                }
                memo[n] = Math.max(memo[n - 2] + value[n], memo[n - 3] + value[n - 1] + value[n]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        value = new int[n + 1];
        memo = new int[n + 1];
        Arrays.fill(memo, init);
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(findMax(n));
    }
}
