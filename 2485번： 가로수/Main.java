/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2485                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2485                           #+#        #+#      #+#    */
/*   Solved: 2024/09/29 14:42:08 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] dist = new int[N - 1];
        int idx = 0;

        ArrayList<Integer> divisor = new ArrayList<>();

        int a = Integer.parseInt(sc.nextLine());
        int sum = 0;
        while (N-- > 1) {
            int b = Integer.parseInt(sc.nextLine());
            dist[idx++] = b - a;
            sum += b - a;
            a = b;
        }

        Arrays.sort(dist);
        int min_dist = dist[0];

        for (int i = 1; i * i <= min_dist; i++) {
            if (min_dist % i == 0) {
                divisor.add(i);
                if (i * i != min_dist)
                    divisor.add(min_dist / i);
            }
        }

        Collections.sort(divisor, Comparator.reverseOrder());
        int g = 1;

        for (int gcd : divisor) {
            boolean flag = true;
            for (int d : dist) {
                if (d % gcd != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                g = gcd;
                break;
            }
        }

        int answer = sum / g - idx;

        System.out.println(answer);

    }
}