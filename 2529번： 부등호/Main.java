/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2529                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2529                           #+#        #+#      #+#    */
/*   Solved: 2024/09/03 15:39:30 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static String answer;

    static boolean matchCondition(int a, int b, String inequality) {
        boolean flag = true;
        switch (inequality) {
            case "<":
                flag = a < b;
                break;
            case ">":
                flag = a > b;
                break;
        }
        return flag;
    }

    static boolean backtrack(int k, int[] numbers, Set<Integer> used, String[] inequalityArray, String minOrMax,
            int index) {

        if (k + 1 == index) {
            StringBuilder sb = new StringBuilder();
            for (int n : numbers) {
                sb.append(n);
            }
            answer = sb.toString();
            return true;
        }

        if (minOrMax.equals("min")) {
            for (int curNum = 0; curNum <= 9; curNum++) {
                if (used.contains(curNum))
                    continue;
                if (index >= 1 && !matchCondition(numbers[index - 1], curNum, inequalityArray[index - 1]))
                    continue;

                numbers[index] = curNum;
                used.add(curNum);

                if (backtrack(k, numbers, used, inequalityArray, minOrMax, index + 1))
                    return true;

                numbers[index] = -1;
                used.remove(curNum);
            }
        }

        if (minOrMax.equals("max")) {
            for (int curNum = 9; curNum >= 0; curNum--) {
                if (used.contains(curNum))
                    continue;
                if (index >= 1 && !matchCondition(numbers[index - 1], curNum, inequalityArray[index - 1]))
                    continue;

                numbers[index] = curNum;
                used.add(curNum);

                if (backtrack(k, numbers, used, inequalityArray, minOrMax, index + 1))
                    return true;

                numbers[index] = -1;
                used.remove(curNum);
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String[] inequalityArray = br.readLine().split(" ");
        String[] minOrMaxArray = new String[] { "max", "min" };

        for (String minOrMax : minOrMaxArray) {
            int[] numbers = new int[k + 1];
            Arrays.fill(numbers, -1);
            int index = 0;
            Set<Integer> used = new HashSet<Integer>();
            backtrack(k, numbers, used, inequalityArray, minOrMax, index);
            System.out.println(answer);
        }

    }
}