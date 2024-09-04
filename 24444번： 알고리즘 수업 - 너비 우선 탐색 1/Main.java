/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 24444                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/24444                          #+#        #+#      #+#    */
/*   Solved: 2024/09/04 21:44:09 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] visited = new int[N + 1];
        int[] answer = new int[N + 1];
        

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(arr.get(i));
        }

        visited[R] = 1;
        queue.add(R);
        int seq = 1;
        answer[R] = seq;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int next : arr.get(cur)) {
                if(visited[next] == 1) continue;
                visited[next] = 1;
                queue.add(next);
                answer[next] = ++seq;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
}