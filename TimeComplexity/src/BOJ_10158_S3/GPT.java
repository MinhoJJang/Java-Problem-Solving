package BOJ_10158_S3;

import java.util.Scanner;

public class GPT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();

        int final_x = (p + t) % w;
        int final_y = (q + t) % h;

        if (((p + t) / w) % 2 == 1) {
            final_x = w - final_x;
        }
        if (((q + t) / h) % 2 == 1) {
            final_y = h - final_y;
        }

        System.out.printf("%d %d", final_x, final_y);
    }
}
// 시간초과