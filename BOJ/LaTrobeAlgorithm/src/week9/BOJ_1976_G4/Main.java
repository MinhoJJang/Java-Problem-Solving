package week9.BOJ_1976_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] map = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j, map);
                }
            }
        }
        // 여행 계획에 있는 도시들
        st = new StringTokenizer(br.readLine());
        List<Integer> travel_list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            travel_list.add(Integer.parseInt(st.nextToken()));
        }

        // 모든 city에 대해 부모노드가 같아야 한다.
        int parent = find(travel_list.get(0), map);
        String result = "YES";
        for (Integer city : travel_list) {
            if (find(city, map) != parent) {
                result = "NO";
            }
        }
        System.out.println(result);
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
