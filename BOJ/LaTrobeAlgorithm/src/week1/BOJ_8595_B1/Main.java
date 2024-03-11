package week1.BOJ_8595_B1;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    final static int init = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        int k;
        int start_idx = init;
        int end_idx;

        /** sum의 최댓값은 int 범위를 아득히 초과할 수 있다. */
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            k = str.charAt(i);
            if (k <= 57 && k >= 48) {
                if (start_idx == init) {
                    start_idx = i;
                }

                // 숫자로 끝나는 경우 체크해야 함
                // ex: 6 12ab23
                if (i == n - 1) {
                    sum = sum.add(new BigInteger(str.substring(start_idx)));
                }
            } else {
                if (start_idx != init) {
                    end_idx = i;
                    if (end_idx - start_idx <= 6) {
                        sum = sum.add(new BigInteger(str.substring(start_idx, end_idx)));
                        start_idx = init;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
