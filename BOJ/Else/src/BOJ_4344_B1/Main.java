package BOJ_4344_B1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int[][] score = new int[C][];
        int[] score_students = new int[C]; // 각 스코어 당 학생수
        int[] score_sum = new int[C]; // 각 스코어 총 합
        float[] score_avg = new float[C]; // 각 스코어 평균
        int[] score_students_over_avg = new int[C]; // 각 스코어 세트에서 평균이 넘는 학생 수
        float[] score_percentage_over_avg = new float[C]; // 각 스코어 세트에서 평균이 넘는 학생 비율

        for (int i = 0; i < C; i++) {
            score_students[i] = sc.nextInt();

            /**
             * 2차원 배열 score의 경우 배열 내부에 대해 다시 초기화해주어야 하므로 아래 코드가 필요하다.
             */
            score[i] = new int[score_students[i]];

            for (int j = 0; j < score_students[i]; j++) {
                score[i][j] = sc.nextInt();
                score_sum[i] += score[i][j];
            }
            score_avg[i] = (float) score_sum[i] / score_students[i];
            for (int j = 0; j < score_students[i]; j++) {
                if (score[i][j] > score_avg[i]) {
                    score_students_over_avg[i]++;
                }
            }
            score_percentage_over_avg[i] = (float) score_students_over_avg[i] / score_students[i] * 100;
            System.out.printf("%.3f%%\n", score_percentage_over_avg[i]);
        }
    }
}
