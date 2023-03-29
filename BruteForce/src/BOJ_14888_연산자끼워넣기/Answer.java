package BOJ_14888_연산자끼워넣기;

import java.io.*;
import java.util.*;

public class Answer {

    static final int plus = 1;
    static final int minus = 2;
    static final int multiply = 3;
    static final int division = 4;

    static final int empty = 0;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt(); // 받을 숫자 개수
        nums = new int[N + 1]; // 받은 숫자 저장 배열
        operators = new int[5]; // 받은 연산자 개수 저장 배열
        order = new int[N + 1]; // 받은 연산자 순서 저장 배열
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        // 이런건 유용하게 써먹을 수 있을듯!
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, order;

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(){
        // TODO
        // 숫자의 순서 nums와 연산자의 순서 order을 사용해야 한다.
        int value = nums[1]; // 맨 첫번째 숫자를 value에 넣는다.
        for (int i = 1; i < N; i++) {
            switch (order[i]){
                case plus: value += nums[i+1]; break;
                case minus: value -= nums[i+1]; break;
                case multiply: value *= nums[i+1]; break;
                // 나누기같은 경우, 원래같으면 0으로 나눈다던지 음수를 나눈다던지 하는
                // 경우를 생각해야 하는데 이 문제에서만큼은 그렇게 하지 않아도 된다.
                case division: value /= nums[i+1]; break;
            }
        }
        return value;
    }


    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k) {
        if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            // TODO
            /*
             k가 N이라면 모든 연산자가 배치된 것임. 즉 식에 맞게 계산하면 되는데
             계산 과정을 분리하여 calculator으로 바꾸면 된다.
             */
            int result = calculator();
            // Math 라이브러리도 이렇게 사용하면 좋다!
            max = Math.max(max, result);
            min = Math.min(min, result);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            // TODO
            // 사실 이게 이 문제에서 제일 핵심임 내가 이걸 못해서 못풀었음...
            // 너무 어렵게 조합 만들고 이렇게 할 필요 없다

            for(int cand=1; cand<=4; cand++){
                // 만약 배치할 수 있는 연산자가 있다면, + - x * 순으로 검사한다.
                if(operators[cand] >= 1){
                    // 일단 연산자 하나 썼잖아? 하나 없애주자
                    operators[cand]--;
                    // 그러면 연산자가 배치되었다는 거니까 order에 넣어주자
                    order[k] = cand;
                    // 이제 연산자도 배치했고 썼다는 증거도 남겼으니 다음 연산자를 배치하러 가보자
                    rec_func(k+1);
                    // 다음 연산자 배치가 모두 끝났다는 것은 위에서 배치한 연산자를 다시 초기화 해줘야 한다. 다른 연산자가 자리할 수 있게 말이야. 그럼 연산자 하나 늘려주고 배치 취소해주면 되겠지?
                    operators[cand]++;
                    order[k] = empty;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}