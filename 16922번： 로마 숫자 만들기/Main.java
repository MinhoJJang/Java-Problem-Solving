/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16922                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16922                          #+#        #+#      #+#    */
/*   Solved: 2024/09/10 13:44:24 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static int[] num = new int[] { 50, 10, 5, 1 };
    static ArrayList<Set<Integer>> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        answer = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            answer.add(new HashSet<>());
        }

        answer.get(0).add(0);
        for (int i = 0; i < n; i++) {
            fn(i);
        }

        System.out.println(answer.get(n).size());
    }

    static void fn(int n) {
        for (int cur : answer.get(n)) {
            for (int i = 0; i < num.length; i++) {
                answer.get(n + 1).add(cur + num[i]);
            }
        }
    }
}