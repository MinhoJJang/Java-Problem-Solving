package BOJ_10431_S5;

import java.util.Scanner;

public class Main {
    static final int MAX_STUDENTS = 20;

    static int calculateSum(int[] student) {
        int sum = 0;
        for (int i = 1; i < MAX_STUDENTS; i++) {
            for (int j = 0; j < i; j++) {
                if (student[j] > student[i]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt(); // testcase_num
        int[][] students = new int[P][MAX_STUDENTS];
        for (int i = 0; i < P; i++) {
            int t = sc.nextInt();
            for (int j = 0; j < MAX_STUDENTS; j++) {
                students[t - 1][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < P; i++) {
            System.out.printf("%d %d\n", i + 1, calculateSum(students[i]));
        }

    }
}
// 맞았습니다!