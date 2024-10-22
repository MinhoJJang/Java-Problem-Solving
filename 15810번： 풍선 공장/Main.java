/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15810                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15810                          #+#        #+#      #+#    */
/*   Solved: 2024/10/22 20:03:31 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] time = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(time);

        long hi = (long) time[0] * M;
        long lo = 0;
        long mid = (hi + lo) / 2;
        long sum = 0;
        long answer = 0;

        while (lo <= hi) {

            sum = 0;
            mid = (hi + lo) / 2;

            for (int i = 0; i < N; i++) {
                sum += mid / time[i];
            }

            if (sum >= M) {
                hi = mid - 1;
                answer = mid;
            } else if (sum < M) {
                lo = mid + 1;
            }
        }

        System.out.println(answer);

    }
}