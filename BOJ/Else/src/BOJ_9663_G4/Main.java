package BOJ_9663_G4;

import java.util.Scanner;

public class Main {

    static int N;
    static int cases = 0;
    static int[] queen;

    // 체크 함수: queen_num 위치에 queen을 놓을 수 있는지 확인
    static boolean canPlaceQueen(int queen_num, int queen_loc) {
        for (int i = 1; i < queen_num; i++) {
            if (queen[i] == queen_loc || // 같은 열에 있는지
                    Math.abs(queen[i] - queen_loc) == Math.abs(i - queen_num)) { // 대각선에 있는지
                return false;
            }
        }
        return true;
    }

    // 재귀 함수로 퀸 배치
    static void locateQueen(int queen_num) {
        if (queen_num > N) {
            cases++;
            return;
        }

        for (int queen_loc = 1; queen_loc <= N; queen_loc++) {
            if (canPlaceQueen(queen_num, queen_loc)) {
                queen[queen_num] = queen_loc; // 퀸 배치
                locateQueen(queen_num + 1); // 다음 퀸 배치 시도
                // 여기에는 되돌아가는(backtracking) 로직이 필요 없음. 자동으로 이전 단계로 되돌아감
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queen = new int[N + 1];
        locateQueen(1); // 첫 번째 퀸부터 시작
        System.out.println(cases);
    }
}
