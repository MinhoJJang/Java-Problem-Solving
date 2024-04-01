package week4.BOJ_18222_S2;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static int reverse_count = 0;

    static BigInteger findLocation(BigInteger k) {

        // 0. k가 0 또는 1일 경우 종료한다
        if (k.equals(BigInteger.ONE) || k.equals(BigInteger.ZERO)) {
            return k;
        }

        // 1. 2^n <= k < 2^n+1 을 만족하는 n을 찾는다
        int n = 0;
        while (k.compareTo(BigInteger.TWO.pow(n)) >= 0) {
            n++;
        }
        n--;

        // 2. findLocation(k - 2^n) 을 호출한다.
        reverse_count++;
        return findLocation(k.subtract(BigInteger.TWO.pow(n)));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BigInteger k = sc.nextBigInteger().subtract(BigInteger.ONE);

        BigInteger original = findLocation(k);
        if (reverse_count % 2 != 0) {
            // reverse_count가 홀수인 경우, original이 0이면 1을, 1이면 0을 출력
            if (original.equals(BigInteger.ZERO)) {
                System.out.println(BigInteger.ONE);
            } else {
                System.out.println(BigInteger.ZERO);
            }
        } else {
            // reverse_count가 짝수인 경우, original 값을 그대로 출력
            System.out.println(original);
        }
    }
}
