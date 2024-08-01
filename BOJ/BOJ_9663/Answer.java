package src.BOJ_9663;

import java.io.*;
import java.util.*;

public class Answer {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;

    static int[] col; // queen 놓는 배열. 체스판이 2차원이라서 2차원 배열이 필요할 것 같지만 1차원으로도 충분하다. 왜? 한 줄에 퀸 하나씩만 놓으니까. 사실상 이 문제를 풀기 위한 핵심 아이디어이다.

    static boolean attackable(int r1, int c1, int r2, int c2) {
        // 공격 가능한 관계라면
        /*
        (직선 공격)
            1. 같은 열에 있거나
        (우상단 대각선 y = x 공격)
            2. 행+열 값이 같은 경우
        (좌상단 대각선 y = -x 공격)
            3. 행-열 값이 같은 경우
         */
        if(c1 == c2 || r1+c1 == r2+c2 || r1-c1 == r2-c2){
            return true;
        }
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            // 애초에 row가 N+1 까지 갔다는 것 자체가 가능한 경우를 모두 체크했다는 소리
            ans++;
        } else {
            /*
                퀸 하나를 놓고, 기존에 위에 놓여진 모든 퀸과 공격가능한지 체크해야 한다.
                놓을 수 있는 위치는 1번부터 최대 N번 까지이다.
             */
            // boolean 위치 설정!!
            // boolean isPossible = true;
            for(int c = 1; c<= N; c++){
                // 현재 row 상태의 col 위치는 (row, c) 이다.
                // 현재 놓인 상태의 퀸을 공격가능한지 체크하자
                // 공격가능한지 체크하려면 이미 놓여진 퀸들의 위치를 가져와서 검사해야 한다.
                // 이때 놓아진 퀸의 개수는 row - 1 일 것이다.
                // 오류! i = 1 로 설정해야, 첫번째 row 가 1 이니까 놓을 수 있다.
                boolean isPossible = true;
                for(int i=1; i<=row-1; i++){
                    if(attackable(row, c, i, col[i])){
                        // 공격 가능하다는 소리니까 더이상 검사할 필요가 없다
                        isPossible = false;
                        break;
                    }
                }

                if(isPossible){
                    // 여기에 들어오려면 서로 공격 가능한 상태가 아니라는 소리다.
                    // 퀸을 놓아준다.
                    col[row] = c;
                    // 다음 row로 넘어가서 검사한다.
                    rec_func(row+1);

                    // rec_func 이 끝났다는 소리는, 내가 이 퀸을 놓고 난 뒤 아래에서 모든 일을 마쳤다는 소리다. 즉 초기화 해줘야 한다.
                    col[row] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
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
