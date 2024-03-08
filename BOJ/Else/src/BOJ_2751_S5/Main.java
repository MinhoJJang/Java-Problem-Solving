package BOJ_2751_S5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException {
        /**
         * 그냥 수를 입력 받으면 안될 것 같고
         * 이걸 어떻게든 빠르게 받는 법이 필요하다.
         * Scanner으로는 절대로 입력을 모두 받을 수 없고
         * 이를 위해 Buffer을 사용한다.
         */

        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 위한 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 먼저 버퍼로부터 N을 받음 (숫자의 개수)
        int N = Integer.parseInt(br.readLine());
        // 숫자를 저장할 List 생성
        List<Integer> numbers = new ArrayList<>();

        // 버퍼에 있는 N개의 숫자를 입력받아 리스트에 저장
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers.add(num);
        }

        // 리스트를 정렬
        Collections.sort(numbers);

        // 정렬된 리스트 출력
        for (int num : numbers) {
            bw.write(num + "\n");
        }

        // 버퍼 비우기
        bw.flush();

        // 스트림 닫기
        br.close();
        bw.close();

    }
}
