package src.BOJ_14888;

import java.util.*;

public class Try {

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
    static int N; // 들어오는 숫자 개수
    static int[] num; // 연산해야 하는 숫자 배열
    static int[] orderOfOperator; // 연산자 순서 배열
    static int[] NumberOfOperator = new int[5]; // 연산자 개수 저장 배열, 편의상 1부터 시작한다.
    static Scanner sc = new Scanner(System.in);
    static int[] ans = new int[2]; // 답안 저장 배열

    static void setUp(){
        N = sc.nextInt();
        num = new int[N];
        orderOfOperator = new int[N-1];
        // 연산할 숫자 배열 저장
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        // 연산자 개수 각각 저장
        for (int i = plus; i <= division; i++) {
            NumberOfOperator[i] = sc.nextInt();
        }
        // 10억, -10억
        ans[MIN] = 1000000000;
        ans[MAX] = -1000000000;
    }

    public static void swap(int i, int j, int[] P) {
        int temp = P[i];
        P[i] = P[j];
        P[j] = temp;
    }

    public static boolean np(int[] P) {

        // 1. 꼭대기를 찾는 과정
        int i = N - 1; // 뒤에서부터 search
        while (i > 0 && P[i - 1] >= P[i])
            --i;

        // 더이상 앞자리가 없는 상황: 현 순열의 상태가 가장 큰순열(마지막 순열)
        if (i == 0)
            return false;

        // 2. 꼭대기 앞자리(i-1)보다 한단계 큰 값을 찾는 과정
        int j = N - 1;
        while (P[i - 1] >= P[j])
            --j;

        // 3. 교환
        swap(i - 1, j, P);

        // 4. i부터 맨뒤까지 오름차순으로 정렬하는데 대칭구조로 정렬!
        int k = N - 1;
        while (i < k) {
            swap(i++, k--, P); // 대칭으로 swap할 때, i는 뒤로가고, k는 앞으로 와야한다.
        }
        return true;
    }

    static void fn(int N, int op){
         /*
            연산자의 위치를 정해주어야 한다. 이때 같은 연산자에 대해 순서는 의미가 없으므로 조합을 사용한다.

            연산자가 4가지이므로, 각 연산자에 따라 조합을 4번 실시한다.
            이때 이전 연산자가 조합으로 가져간 위치는 다음 연산자가 선택할 수 없도록 한다.
            배치할 수 있는 곳은 orderOfOperator이 0인 지점을 선택하도록 한다.
            만약 +을 배치했다면, orderOfOperator 배열에서 +가 위치한 곳을 plus(==1)으로 초기화해준다.
         */

         // 1. 각 연산자에 대해 4번 조합을 해야하니 for문을 돌려준다. op == 1 일 경우 +를 배치한다는 뜻이다.
        //for (int op = 1; op <= 4; op++) {

            // N은 숫자 개수이다.
            // R은 뽑는 숫자 개수 = 연산자 개수이다.
            int R = NumberOfOperator[op];
            // input은 선택할 수 있는 연산자 위치 배열이다.
            // 이때 선택할 수 있는 연산자 위치는, orderOfOperator에서 0인 지점이다.
            // 즉 input의 길이를 설정해주기 위해 따로 변수 len 을 만들어주자.
            int len = 0;
            for (int i = 0; i < N-1; i++) {
                if(orderOfOperator[i] == 0){
                    // 이게 0이라는 소리는 아직 연산자가 선택되지 않았다는 의미이다.
                    len++;
                }
            }
            int[] input = new int[len];
            int inputIdx = 0;
            for (int idx = 0; idx < N-1; idx++) {
                if(orderOfOperator[idx] == 0){
                    // 이게 0인 자리를 선택할 수 있다는 소리이므로 input에 idx을 넣어준다.
                    input[inputIdx++] = idx;
                }
            }

            // 여기까지가, 조합을 구하기 위한 사전과정

//            // opArr 은 orderOfOperator 을 위한 배열이다.
//            int[] opArr = new int[N-1];
//            int cnt = 0;
//            while (++cnt <= R)
//                opArr[N - 1 - cnt] = op; // 전치연산을 했기 때문에 조건문에 등호를 포함함.

//            do {
//                for (int i = 0; i < N-1; i++) {
//                    if (opArr[i] != 0) {
//                        System.out.print(input[i] + " ");
//
//                    }
//                }
//                System.out.println();
//            } while (np(opArr));
//            // 여기서 문제.
//            // 이걸 조합하는건 좋은데, 어디 로직 사이에 넣어야되는가?
//            // 어렵네...........
        //}
    }

    static void mn(){

    }



    static void setOp(){

        // 연산자가 들어갈 수 있는 공간 체크
        int[] available_location = new int[N-1];
        int idx = 0;
        for (int i = 0; i < N-1; i++) {
            if(orderOfOperator[i] == empty){
                available_location[idx++] = i;
            }
        }
        int j = 0;
        // 연산자 배치
        // 이때 같은 연산자에 대해서는 순서가 의미가 없다. 즉 조합을 사용해야한다.
        for (int i = available_location[j]; j < idx; j++) {

        }

    }

    public static void main(String[] args) {

    }
}

