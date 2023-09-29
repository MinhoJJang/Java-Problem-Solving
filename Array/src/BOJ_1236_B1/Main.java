package BOJ_1236_B1;

import java.util.Scanner;

public class Main {

    static void checkX(char[][] status){
        int w = status[0].length; // 가로길이
        int h = status.length; // 세로길이
        int needX = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

            }
        }

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

    }
}
