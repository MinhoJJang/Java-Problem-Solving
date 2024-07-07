package week11.BOJ_15961_G4;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];

        int cnt = 0;
        int max = 0;

        // 쿠폰 초밥 추가
        count[c]++;
        cnt++;

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) cnt++;
            count[sushi[i]]++;
        }
        max = cnt;

        // 슬라이딩 윈도우
        for (int i = 1; i < N; i++) {
            // 이전 윈도우의 첫 번째 초밥 제거
            int prevSushi = sushi[i - 1];
            count[prevSushi]--;
            if (count[prevSushi] == 0) cnt--;

            // 현재 윈도우의 마지막 초밥 추가
            int newSushi = sushi[(i + k - 1) % N];
            if (count[newSushi] == 0) cnt++;
            count[newSushi]++;

            // 최대값 갱신
            if (cnt > max) max = cnt;
        }

        System.out.println(max);
    }
}
