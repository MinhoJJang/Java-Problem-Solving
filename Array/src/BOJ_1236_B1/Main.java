package BOJ_1236_B1;

import java.util.Scanner;

public class Main {

    static int checkX(char[][] status) {
        int w = status[0].length; // 가로길이
        int h = status.length; // 세로길이
        int needH = 0; // 가로가 텅 빌 경우 +1
        int needW = 0; // 세로가 텅 빌 경우 +1

        // 가로가 비었는지 체크
        for (int i = 0; i < h; i++) {
            int j;

            for (j = 0; j < w; j++) {
                if (status[i][j] == 'X') {
                    break;
                }
            }

            if (j == w) {
                needH++;
            }
        }

        // 세로가 비었는지 체크
        for (int i = 0; i < w; i++) {
            int j;

            for (j = 0; j < h; j++) {
                if (status[j][i] == 'X') {
                    break;
                }
            }

            if (j == h) {
                needW++;
            }
        }

        if (needW > needH) {
            return needW;
        }
        return needH;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        char[][] status = new char[N][M];
        for (int i = 0; i < N; i++) {
            status[i] = sc.next().toCharArray();
        }
        System.out.println(checkX(status));
    }
}
