package week9.BOJ_1717_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void union(int a, int b, int[] map) {
        // a의 부모가 이제 b의 자식이 된다.
        map[find(a, map)] = map[find(b, map)];
    }

    private static int find(int a, int[] map) {
        if (map[a] != a) {
            return map[a] = find(map[a], map);
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int map[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = i;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int fomula = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (fomula == 0) {
                union(a, b, map);
            } else {
                if (find(a, map) == find(b, map)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
