package week9.BOJ_20040_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }

        int cycled = 0;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 이미 두 노드를 연결하기 전부터 그들의 부모가 같다면, 이는 사이클이다.
            if (find(a, map) == find(b, map)) {
                cycled = i;
                break;
            }
            union(a, b, map);
        }
        System.out.println(cycled);
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
