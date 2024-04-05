package week5.BOJ_13699_S4;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static BigInteger[] memo;
    static BigInteger init = BigInteger.valueOf(-1);

    static BigInteger recurrence_formula(int n) {
        if (memo[n].equals(init)) {
            if (n == 0) {
                memo[n] = BigInteger.valueOf(1);
            } else if (n <= 2) {
                memo[n] = BigInteger.valueOf(n);
            } else if (n == 3) {
                memo[n] = BigInteger.valueOf(5);
            } else {
                memo[n] = BigInteger.ZERO;
                for (int i = 0; i < n; i++) {
                    if (memo[i].equals(init)) {
                        memo[i] = recurrence_formula(i);
                    }
                    if (memo[n - 1 - i].equals(init)) {
                        memo[n - 1 - i] = recurrence_formula(n - 1 - i);
                    }
                    memo[n] = memo[n].add(memo[i].multiply(memo[n - 1 - i]));
                }
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new BigInteger[n + 1];
        Arrays.fill(memo, init);
        System.out.println(recurrence_formula(n).toString());
    }
}
