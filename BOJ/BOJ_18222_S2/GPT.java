package week4.BOJ_18222_S2;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class GPT {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BigInteger k = sc.nextBigInteger().subtract(BigInteger.ONE); // Adjust for 0-indexing
        System.out.println(findThueMorseValue(k));
    }

    static int findThueMorseValue(BigInteger k) {
        int count = 0;
        while (k.compareTo(BigInteger.ZERO) > 0) {
            count += k.and(BigInteger.ONE).intValue();
            k = k.shiftRight(1);
        }
        return count % 2 == 0 ? 0 : 1;
    }
}
