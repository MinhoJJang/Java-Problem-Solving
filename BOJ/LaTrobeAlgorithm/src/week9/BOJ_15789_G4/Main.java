package week9.BOJ_15789_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = i;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, map);
        }

        st = new StringTokenizer(br.readLine());
        int C_head = find(Integer.parseInt(st.nextToken()), map); // CTP 왕국의 부모
        int H_head = find(Integer.parseInt(st.nextToken()), map); // 한솔 왕국의 부모
        int k = Integer.parseInt(st.nextToken()); // 추가 동맹 횟수

        // 모든 왕국의 힘을 저장하는 배열
        int[] power = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            power[find(i, map)]++;
        }

        int CTP_power = power[C_head]; // CTP 왕국만의 힘

        power[H_head] = 0; // 한솔 왕국과는 동맹할 수 없으니 0으로 만들어준다.
        power[C_head] = 0; // 자신과 이미 동맹이면 다시 동맹 맺어도 의미가 없으니 0으로 만들어준다.

        // 다른 왕국들의 힘을 내림차순 정렬한다.
        int[] sortedPower = IntStream.of(power)
                .boxed() // int를 Integer로 박싱
                .sorted(Collections.reverseOrder()) // 내림차순 정렬
                .mapToInt(Integer::intValue) // Integer를 int로 언박싱
                .toArray(); // 배열로 반환

        // 모든 동맹을 사용하지 않아도 되고, 동맹의 추가 횟수가 실제 왕국의 수보다 많을 수도 있다. (오버플로 방지)
        int len = k < sortedPower.length ? k : sortedPower.length;
        for (int i = 0; i < len; i++) {
            CTP_power += sortedPower[i];
        }

        System.out.println(CTP_power);
    }

    private static void union(int a, int b, int[] map) {
        map[find(a, map)] = map[find(b, map)];
    }

    private static int find(int a, int[] map) {
        if (map[a] != a) {
            return map[a] = find(map[a], map);
        }
        return a;
    }
}
