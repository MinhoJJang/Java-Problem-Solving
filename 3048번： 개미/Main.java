/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3048                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3048                           #+#        #+#      #+#    */
/*   Solved: 2024/09/10 04:10:22 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static char[] seq;
    static int[] dir;

    static final int LEFT = -1;
    static final int RIGHT = 1;

    static void swap(int n) {
        char temp = seq[n];
        seq[n] = seq[n + 1];
        dir[n] = LEFT;
        seq[n + 1] = temp;
        dir[n + 1] = RIGHT;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        char[] g1 = br.readLine().toCharArray();
        char[] g2 = br.readLine().toCharArray();
        int T = Integer.parseInt(br.readLine());

        int idx = 0;
        int len = g1.length + g2.length;
        seq = new char[len];
        dir = new int[len];

        for (int i = N1 - 1; i >= 0; i--) {
            seq[idx] = g1[i];
            dir[idx] = RIGHT;
            idx += 1;
        }

        for (int i = 0; i < g2.length; i++) {
            seq[idx] = g2[i];
            dir[idx] = LEFT;
            idx += 1;
        }

        while (T-- > 0) {
            for (int i = 0; i < len - 1; i++) {
                if (dir[i] == RIGHT && dir[i + 1] == LEFT) {
                    swap(i);
                    i++;
                }
            }
        }

        for (int i = 0; i < seq.length; i++) {
            System.out.print(seq[i]);
        }

    }
}