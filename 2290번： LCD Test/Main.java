/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2290                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2290                           #+#        #+#      #+#    */
/*   Solved: 2024/09/09 23:51:57 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {
    static String[] LCD = new String[] {
            "1110111", "0010010", "1011101", "1011011", "0111010",
            "1101011", "1101111", "1010010", "1111111", "1111011"
    };

    static final char WIDTH = '-';
    static final char HEIGHT = '|';
    static char[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        int len = n.length();
        int rows = 2 * s + 3;
        int cols = len * (s + 3) + 1;

        answer = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(answer[i], ' ');
        }

        for (int i = 0; i < len; i++) {
            int num = n.charAt(i) - '0';
            drawNumber(num, i * (s + 3), s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(new String(answer[i])).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void drawNumber(int num, int offset, int s) {
        String segments = LCD[num];
        int h = 2 * s + 3;

        if (segments.charAt(0) == '1') {
            for (int i = 1; i <= s; i++)
                answer[0][offset + i] = WIDTH;
        }
        if (segments.charAt(1) == '1') {
            for (int i = 1; i <= s; i++)
                answer[i][offset] = HEIGHT;
        }
        if (segments.charAt(2) == '1') {
            for (int i = 1; i <= s; i++)
                answer[i][offset + s + 1] = HEIGHT;
        }
        if (segments.charAt(3) == '1') {
            for (int i = 1; i <= s; i++)
                answer[s + 1][offset + i] = WIDTH;
        }
        if (segments.charAt(4) == '1') {
            for (int i = s + 2; i < h - 1; i++)
                answer[i][offset] = HEIGHT;
        }
        if (segments.charAt(5) == '1') {
            for (int i = s + 2; i < h - 1; i++)
                answer[i][offset + s + 1] = HEIGHT;
        }
        if (segments.charAt(6) == '1') {
            for (int i = 1; i <= s; i++)
                answer[h - 1][offset + i] = WIDTH;
        }
    }
}