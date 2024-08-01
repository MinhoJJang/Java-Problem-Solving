package src.BOJ_1730_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int X = 0;
    static final int Y = 1;
    static int N;
    static String[][] memorizeMoving;
    static char[][] answer;

    static void movingPointAndMemorizeMoving(char direction, int[] point) {

        int[] point2 = new int[2];
        point2[X] = point[X];
        point2[Y] = point[Y];

        switch (direction) {
            case 'U':
                point[X] -= 1;
                break;
            case 'D':
                point[X] += 1;
                break;
            case 'L':
                point[Y] -= 1;
                break;
            case 'R':
                point[Y] += 1;
                break;
        }

        if (checkIsValidPoint(point, N)) {
            memorizeMoving[point2[X]][point2[Y]] += direction;
            memorizeMoving[point[X]][point[Y]] += direction;
        }
    }

    static boolean checkIsValidPoint(int[] point, int x) {

        for (int i = 0; i < 2; i++) {
            if (point[i] < 0) {
                point[i] = 0;
                return false;
            }
            if (point[i] >= x) {
                point[i] = x - 1;
                return false;
            }
        }
        return true;
    }

    static void setAnswerWithMemorizeMoving() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                boolean upAndDown = memorizeMoving[i][j].contains("U") || memorizeMoving[i][j].contains("D");
                boolean leftAndRight = memorizeMoving[i][j].contains("L") || memorizeMoving[i][j].contains("R");

                if (upAndDown && leftAndRight) {
                    answer[i][j] = (char) 43;
                } else if (upAndDown && !leftAndRight) {
                    answer[i][j] = (char) 124;
                } else if (!upAndDown && leftAndRight) {
                    answer[i][j] = (char) 45;
                }
            }
        }
    }

    static void printAnswer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());
            memorizeMoving = new String[N][N];
            answer = new char[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(memorizeMoving[i], "");
                Arrays.fill(answer[i], (char) 46); // 46 = .
            }

            String inputMoving_String = br.readLine();
            char[] inputMoving_charArr = inputMoving_String.toCharArray();
            int[] point = {0, 0};
            for (int i = 0; i < inputMoving_charArr.length; i++) {
                movingPointAndMemorizeMoving(inputMoving_charArr[i], point);
            }
            setAnswerWithMemorizeMoving();

            printAnswer();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        memorizeMoving = new String[N][N];
//        answer = new char[N][N];
//
//        for (int i = 0; i < N; i++) {
//            Arrays.fill(memorizeMoving[i], "");
//            Arrays.fill(answer[i], (char) 46); // 46 = .
//        }
//
//        String inputMoving_String = sc.next();
//        char[] inputMoving_charArr = inputMoving_String.toCharArray();
//        int[] point = {0, 0};
//        for (int i = 0; i < inputMoving_charArr.length; i++) {
//            movingPointAndMemorizeMoving(inputMoving_charArr[i], point);
//        }
//        setAnswerWithMemorizeMoving();
//
//        printAnswer();
//    }
}
