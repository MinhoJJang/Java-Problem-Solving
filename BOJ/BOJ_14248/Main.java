//package BOJ_14248;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] rock = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rock[i + 1] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int jump = rock[cur];

            if (cur + jump <= n && !visited[cur + jump]) {
                queue.add(cur + jump);
                visited[cur + jump] = true;
            }

            if (cur - jump > 0 && !visited[cur - jump]) {
                queue.add(cur - jump);
                visited[cur - jump] = true;
            }
        }

        int answer = 0;
        for (boolean b : visited) {
            if (b)
                answer++;
        }

        System.out.println(answer);
    }
}
