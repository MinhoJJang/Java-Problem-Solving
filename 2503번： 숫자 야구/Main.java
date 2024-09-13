/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2503                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2503                           #+#        #+#      #+#    */
/*   Solved: 2024/09/13 12:26:54 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static class Info {
        int num;
        int strike;
        int ball;

        public Info(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static ArrayList<Info> questions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        questions = new ArrayList<>();
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            questions.add(new Info(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }

        int answer = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if(i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    if(i == k || j == k) continue; 
                    int candidate = i * 100 + j * 10 + k;
                    if(checkIsValid(candidate)) answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean checkIsValid(int num){
        for(Info info : questions){
            if(!checkIsAvailable(info, num)) return false;
        }
        return true;
    }

    static boolean checkIsAvailable(Info info, int num){
        int strike = 0;
        int ball = 0;

        char[] num1 = String.valueOf(info.num).toCharArray();
        char[] num2 = String.valueOf(num).toCharArray();

        for (int i = 0; i < num2.length; i++) {
            if(num1[i] == num2[i]) strike++;
            else if(num1[i] == num2[(i+1)%3] || num1[i] == num2[(i+2)%3]) ball++;
        }

        if(info.strike == strike && info.ball == ball) return true;
        return false;
    }
}