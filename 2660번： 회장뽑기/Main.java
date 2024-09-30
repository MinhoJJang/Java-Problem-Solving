/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2660                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2660                           #+#        #+#      #+#    */
/*   Solved: 2024/09/30 21:46:58 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        StringTokenizer st;
        int[] member_score = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1)
                break;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int candidate_score = 51;

        for (int start = 1; start <= N; start++) {
            int[] score = new int[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            Arrays.fill(score, -1);
            score[start] = 0;
            queue.add(start);
            member_score[start] = bfs(graph, queue, score);
            candidate_score = Math.min(candidate_score, member_score[start]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if(member_score[i] == candidate_score){
                cnt++;
                answer.add(i);
            }
        }

        System.out.println(candidate_score + " " + cnt);
        for (Integer candidate : answer) {
            System.out.print(candidate + " "); 
        }

    }

    static int bfs(ArrayList<ArrayList<Integer>> graph, Queue<Integer> queue, int[] score) {
        int max = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (score[next] == -1) {
                    score[next] = score[cur] + 1;
                    queue.add(next);
                    max = score[next];
                }
            }
        }
        return max;
    }
}