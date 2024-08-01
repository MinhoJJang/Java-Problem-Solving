package week5.BOJ_2705_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] memo;
    static final int init = -1;

    public static int fn(int n) {

        if (memo[n] == init) {
            if (n <= 2) {
                memo[n] = n;
            }
            if (n == 3) {
                memo[n] = 2;
            } else {
                int k = n / 2;
                int sum = 1; // n자신은 반드시 존재한다.
                for (int i = 1; i <= k; i++) {
                    if (memo[i] == init) {
                        memo[i] = fn(i);
                    }
                    sum += memo[i];
                }
                memo[n] = sum;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            memo = new int[n+1];
            Arrays.fill(memo, init);
            System.out.println(fn(n));
        }
    }
}
