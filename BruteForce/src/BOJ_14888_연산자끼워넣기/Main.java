package BOJ_14888_연산자끼워넣기;

import java.io.*;
import java.util.*;

public class Main {

    /*
        N = 숫자 개수
        num[N] = 숫자 배열
        op[4] = 연산자 개수 저장 배열
        ans = 답안 저장 배열
     */
    static final int plus = 1;
    static final int minus = 2;
    static final int multiply = 3;
    static final int division = 4;

    static final int empty = 0;

    static final int MAX = 1;
    static final int MIN = 0;
    static int N;
    static int[] num;
    static int[] order;
    static int[] op = new int[4];
    static Scanner sc = new Scanner(System.in);
    static int[] ans = new int[2];

    static void setUp(){
        N = sc.nextInt();
        num = new int[N];
        order = new int[N-1];
        // 연산할 숫자 배열 저장
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        // 연산자 개수 각각 저장
        for (int i = 1; i < 5; i++) {
            op[i] = sc.nextInt();
        }
        // 10억, -10억
        ans[MIN] = 1000000000;
        ans[MAX] = -1000000000;
    }

    static void fn(){
         /*
            모든 경우의 수를 한번씩, 연산자의 배열을 만들어야 한다.
            어떻게 연산자 배열을 저장할 것인가? 랜덤하게 선택해서는 정확성이 없다.

            연산자의 배열 order[N-1] 생성
            order[0] ... order[N-1] 까지, 0,1,2,3 을 넣는다 (각각 plus, minus, multiply, division) 이때 0,1,2,3 으로 이루어진 배열이 중복되어서는 안된다. (시간 아끼기)
            근데 어떻게 만들지...?

            4,1,2,3 이라면... recursive for 문 사용해볼까

            만들기만 하면, order 배열을 함수에 전달한 후 해당 순서에 따라 계산을 진행하면 된다.
         */


    }

    static void setOp(){

        // 연산자가 들어갈 수 있는 공간 체크
        int[] available_location = new int[N-1];
        int idx = 0;
        for (int i = 0; i < N-1; i++) {
            if(order[i] == empty){
                available_location[idx++] = i;
            }
        }
        int j = 0;
        // 연산자 배치
        for (int i = available_location[j]; j < idx; j++) {

        }

    }

    public static void main(String[] args) {

    }
}

