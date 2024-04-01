package week4.BOJ_17484_S3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final Integer LEFT = -1;
    static final Integer STRAIGHT = 0;
    static final Integer RIGHT = 1;

    static int optimal_value = Integer.MAX_VALUE;

    static void findOptimalWay(int previous_location, Integer previous_direction, int depth, int local_sum, int[][] value) {
        // 1. 만약 depth이 N과 같다면 가중치 값을 구하여 종료한다.
        if (depth == value.length - 1) {
            if (optimal_value > local_sum) {
                optimal_value = local_sum;
            }
            return;
        }

        // 2. 가능한 이동 방향을 찾기위한 ArrayList을 생성한다.
        ArrayList<Integer> available_direction = new ArrayList<>();
        available_direction.add(LEFT);
        available_direction.add(RIGHT);
        available_direction.add(STRAIGHT);

        // 2-1. 일단 previous direction 은 아니어야 한다.
        available_direction.remove(previous_direction);

        // 2-2. 그리고 만약 previous_location이 0또는 M-1일 경우도 생각하자
        if (previous_location == 0) {
            available_direction.remove(LEFT);
        }
        if (previous_location == value[0].length - 1) {
            available_direction.remove(RIGHT);
        }

        // 3. 이동 가능한 방향을 모두 가본다. 다음 방향으로 이동한다.
        for (int i = 0; i < available_direction.size(); i++) {
            int current_direction = available_direction.get(i);
            depth++;
            local_sum += value[depth][previous_location + current_direction];
            findOptimalWay(previous_location + current_direction, current_direction, depth, local_sum, value);
            local_sum -= value[depth][previous_location + current_direction];
            depth--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] value = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                value[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            // 시작 위치를 정한다. 0부터 M-1까지가 있을 것
            // 1. 틀린이유 여기있음.. 시작위치는 방향이 없으니까 null을 전달하는게 맞다.
            findOptimalWay(i, null, 0, value[0][i], value);
        }

        System.out.println(optimal_value);

    }
}
