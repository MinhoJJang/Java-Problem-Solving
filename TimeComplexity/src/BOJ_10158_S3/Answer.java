package BOJ_10158_S3;

import java.util.Scanner;

public class Answer
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int T = sc.nextInt();

        int p = (P + T) % (2 * W);
        int q = (Q + T) % (2 * H);
        if (p > W) p = 2 * W - p;
        if (q > H) q = 2 * H - q;
        System.out.println(p+ " "+q);
    }
}
// 제출 언어를 Java 15가 아니라 Java 8로 해주자