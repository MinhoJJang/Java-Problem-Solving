package BOJ_13549_G5;

import java.io.*;
import java.util.*;

public class Main {

    static int INIT = 100001;

    public static void main(String[] args) throws IOException {
        // 수빈이가 있는 위치 N
        // 동생이 있는 위치 K
        /*
            0 <= N <= 100,000

            X -> 2X = 0sec
            X +- 1 = 1sec
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[100000 * 3];
        Arrays.fill(visited, INIT);

        // 초기 수빈이 위치
        visited[N] = 0;
        queue.add(N);
        int result = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) {
                result = visited[K];
                break;
            }

            int next_2x = 2 * cur;
            while (next_2x <= 200000) {
                if (visited[next_2x] != INIT) break;
                queue.add(next_2x);
                visited[next_2x] = visited[cur];
                next_2x *= 2;
            }

            int[] next = new int[]{cur - 1, cur + 1};
            for (int n : next) {
                if (n < 0 || n > 200000) continue;
                if (visited[n] != INIT) continue;
                queue.add(n);
                visited[n] = visited[cur] + 1;
            }
        }
        System.out.println(result);
    }
}
