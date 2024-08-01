package src.BOJ_3085_S2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int PREVIOUS = -1;
    static final int NEXT = 1;
    static int GlobalLongestLength = 1;
    static int N;
    static char[] candy_name = {'C', 'P', 'Z', 'Y'};

    static int findLongestSequenceCharLength(char[][] arr) {

        // C, P, Z, Y 에 대하여 연속된 값의 최대 숫자 구하기
        for (int i = 0; i < N; i++) {

            // 1. raw 행을 먼저 구함
            findLocalLongestLength(arr[i]);

            // 2. 해당 행의 위 배열 값과 위치 변경
            if (i > 0) {
                for (int j = 0; j < N; j++) {
                    findLocalLongestLength(switchCandyVertically(arr[i], j, arr[i - 1][j]));
                    if (j > 0) {
                        findLocalLongestLength(switchCandyHorizontally(arr[i], j, arr[i][j - 1], PREVIOUS));
                    }
                    if (j < N - 1) {
                        findLocalLongestLength(switchCandyHorizontally(arr[i], j, arr[i][j + 1], NEXT));
                    }
                }
            }

            // 3. 해당 행의 아래 배열 값과 위치 변경
            if (i < N - 1) {
                for (int j = 0; j < N; j++) {
                    findLocalLongestLength(switchCandyVertically(arr[i], j, arr[i + 1][j]));
                    if (j > 0) {
                        findLocalLongestLength(switchCandyHorizontally(arr[i], j, arr[i][j - 1], PREVIOUS));
                    }
                    if (j < N - 1) {
                        findLocalLongestLength(switchCandyHorizontally(arr[i], j, arr[i][j + 1], NEXT));
                    }
                }
            }
        }
        return GlobalLongestLength;
    }

    static void findLocalLongestLength(char[] arr) {
        int LocalLongestLength = 1;
        for (int i = 0; i < candy_name.length; i++) {
            int temp;
            for (int j = 0; j < N; j++) {
                if (arr[j] == candy_name[i]) {
                    temp = 0;
                    while (j < N && arr[j] == candy_name[i]) {
                        j++;
                        temp++;
                    }
                    if (temp > LocalLongestLength) {
                        LocalLongestLength = temp;
                    }
                }
            }
        }

        if (GlobalLongestLength < LocalLongestLength) {
            GlobalLongestLength = LocalLongestLength;
        }
    }

    static char[] switchCandyVertically(char[] base, int idx, char c) {
        char[] dest = Arrays.copyOf(base, N);
        dest[idx] = c;
        return dest;
    }

    static char[] switchCandyHorizontally(char[] base, int idx, char c, int dir) {
        char[] dest = Arrays.copyOf(base, N);
        dest[idx + dir] = dest[idx];
        dest[idx] = c;

        return dest;
    }
    

    static void transpose(char[][] arr, char[][] arr2) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr2[j][i] = arr[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        char[][] candy = new char[N][N];
        char[][] candyT = new char[N][N]; // Transpose 된 candy 배열

        for (int i = 0; i < N; i++) {
            candy[i] = sc.next().toCharArray();
        }

        transpose(candy, candyT);
        findLongestSequenceCharLength(candy);
        findLongestSequenceCharLength(candyT);

        System.out.println(GlobalLongestLength);
    }
}
