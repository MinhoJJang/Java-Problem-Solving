package week4.BOJ_1922_S1;

import java.util.Scanner;

public class Main {

    static String convert(String s) {
        if (s.contains("1") && !s.contains("0")) {
            return "1";
        } else if (!s.contains("1") && s.contains("0")) {
            return "0";
        }
        return "(" + s + ")";
    }

    static String quad(String[][] arr, int x, int y, int size) {
        if (size == 1) {
            return arr[x][y];
        }

        int newSize = size / 2;
        String result = "";

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result += quad(arr, x + i * newSize, y + j * newSize, newSize);
            }
        }

        return convert(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        System.out.println(quad(arr, 0, 0, n));
    }
}
