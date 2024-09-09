/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17609                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17609                          #+#        #+#      #+#    */
/*   Solved: 2024/09/04 22:04:05 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static boolean findPalin(String s) {

        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    static String removeCharacter(String s, int idx) {
        String s1 = s.substring(0, idx);
        String s2 = s.substring(idx + 1, s.length());
        return s1.concat(s2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] input = new String[T];
        int[] answer = new int[T];
        for (int i = 0; i < T; i++) {
            input[i] = br.readLine();
            int status = 2;

            if (findPalin(input[i])) {
                status = 0;
            } else {
                int len = input[i].length();
                for (int j = 0; j < len; j++) {
                    if (findPalin(removeCharacter(input[i], j))) {
                        status = 1;
                        break;
                    }
                }
            }
            answer[i] = status;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}