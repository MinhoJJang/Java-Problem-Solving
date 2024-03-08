package BOJ_10989_B1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 위한 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 이 문제는 Array[10001] 을 만든 다음, 입력이 들어올 때 마다 숫자 자체를
         * 저장하는 것이 아니라 그 배열의 index 값을 1 증가시키는 것이 아이디어이다.
         */
        final int max_N = 10001;
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[max_N];
        for (int i = 1; i <= N; i++) {
            number[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < max_N; i++) {
            for (int j = 0; j < number[i]; j++) {
                bw.write(i + "\n");
            }
        }

        // 버퍼 비우기
        bw.flush();

        // 스트림 닫기
        br.close();
        bw.close();
    }
}
