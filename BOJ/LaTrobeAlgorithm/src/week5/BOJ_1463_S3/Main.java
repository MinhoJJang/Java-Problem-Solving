package week5.BOJ_1463_S3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int global_minimum = Integer.MAX_VALUE;
    static int[] memo;
    static final int init = -1;

    static int fn(int n) {

        if (memo[n] == init) {
            if (n == 1) {
                memo[n] = 0;
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                if (n % 3 == 0) {
                    if (memo[n / 3] == init) {
                        memo[n / 3] = fn(n / 3);
                    }
                    arr.add(memo[n / 3]);
                }
                if (n % 2 == 0) {
                    if (memo[n / 2] == init) {
                        memo[n / 2] = fn(n / 2);
                    }
                    arr.add(memo[n / 2]);
                }
                if (memo[n - 1] == init) {
                    memo[n - 1] = fn(n - 1);
                }
                arr.add(memo[n - 1]);
                memo[n] = Collections.min(arr) + 1;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        Arrays.fill(memo, init);
        System.out.println(fn(n));
    }
}
