/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 28278                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/28278                          #+#        #+#      #+#    */
/*   Solved: 2024/09/03 17:02:58 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int answer = 0;
            switch (input[0]) {
                case "1":
                    stack.add(Integer.parseInt(input[1]));
                    break;
                case "2":
                    answer = -1;
                    if (!stack.isEmpty())
                        answer = stack.pop();
                    break;
                case "3":
                    answer = stack.size();
                    break;
                case "4":
                    answer = 0;
                    if (stack.isEmpty())
                        answer = 1;
                    break;
                case "5":
                    answer = -1;
                    if (!stack.isEmpty())
                        answer = stack.peek();
                    break;
            }

            if (!input[0].equals("1")) {
                System.out.println(answer);
            }

        }
    }
}