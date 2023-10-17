package BOJ_3085_S2;

import java.util.Scanner;

public class Main {

    static int LongestLength = 0;
    static int N;
    static int findLongestSequenceCharLength(char[] arr){

        return LongestLength;
    }

    static void transpose(int arr[][], int arr2[][]) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
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


        for (int i = 0; i < N; i++) {
            findLongestSequenceCharLength(candy[i]);
        }

    }
}
