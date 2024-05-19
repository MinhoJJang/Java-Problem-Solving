package week9.BOJ_16562_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] friend_cost = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friend_cost[i] = Integer.parseInt(st.nextToken());
        }

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

        /*
         최소 친구비 계산

         모든 친구에 대해, 각 친구의 부모에 해당하는 친구를 (== find(a,map) 인덱스로 최솟값을 저장한다.
         */

        int[] lowest_friend_cost = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int parent = find(i, map);
            if (lowest_friend_cost[parent] == 0) {
                lowest_friend_cost[parent] = friend_cost[i];
            } else {
                if (lowest_friend_cost[parent] > friend_cost[i]) {
                    lowest_friend_cost[parent] = friend_cost[i];
                }
            }
        }

        int total = 0;
        for (int cost : lowest_friend_cost) {
            total += cost;
        }

        if (total <= k) {
            System.out.println(total);
        } else {
            System.out.println("Oh no");
        }
    }

    private static void union(int a, int b, int[] map) {
        // a의 부모와 b의 부모를 서로 연결해주는 작업
        map[find(a, map)] = map[find(b, map)];
    }

    private static int find(int a, int[] map) {
        // a의 부모를 리턴하는 함수
        if (map[a] != a) {
            return map[a] = find(map[a], map);
        }
        return a;
    }
}
