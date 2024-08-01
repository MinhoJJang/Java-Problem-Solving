package BOJ_9663_G4;

import java.util.Scanner;

public class Wrong {

    static int N;
    static int cases = 0;

    // 퀸 위치 저장 배열
    static int queen[];

    static boolean can_be_located(int queen_num, int queen_loc){
        for (int i = queen_num - 1; i > 0 ; i--) {
            if(queen_loc == queen[i] || queen_loc == (queen[i] - (queen_num - i)) || queen_loc == queen[i] + (queen_num - i)){
                return false;
            }
        }
        return true;
    }

    // 퀸 놓는 작업 함수
    /*
    Point 1. 여기서 너무 쓸데없이 많은 재귀호출을 부르고 있어 N이 9 이상일 경우 제대로 호출이 되지 않는다.
    즉, StackOverFlow가 발생함..
     */
    static boolean locating(int queen_num, int prev_loc){

        if(queen[1] == 4 && queen_num == 1){
            System.out.println(queen[1]);
        }

        if(prev_loc == N) {
            if(queen_num == 1){
                return true;
            }
            else {
                queen[queen_num] = 0;
                if(locating(queen_num - 1, queen[queen_num-1])){
                    return true;
                }
            }
        }

        for (int queen_loc = prev_loc+1; queen_loc < N+1; queen_loc++) {
            // 퀸 번호와 퀸 위치로 놓을 수 있는지 여부를 체크한다.
            if(can_be_located(queen_num, queen_loc) == true){
                queen[queen_num] = queen_loc;
                if(queen_num == N){
                    cases++;
                }
                else {
                    if(locating(queen_num+1, 0)){
                        return true;
                    };
                }
            }
            else if(queen_loc == N){
                queen[queen_num] = 0;
                if(locating(queen_num - 1, queen[queen_num-1])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queen = new int[N+1];
        locating(1, 0);
        System.out.println(cases);
    }
}