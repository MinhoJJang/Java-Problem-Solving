package week2.BOJ_9012_S4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * 빠르게 알아내는 법
         * 1. 길이가 홀수면 즉시 NO
         * 2. 길이가 짝수일경우
         *    (을 만나면 +1
         *    )을 만나면 -1
         *    이 점수가 음수가 되는 즉시 NO
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i <n; i++) {
            String input = sc.nextLine();
            String res = "YES";
            int len = input.length();
            if(len % 2 != 0){
                res = "NO";
            }
            else{
                int score = 0;
                char[] arr = input.toCharArray();
                for(char c : arr){
                    if(c == '('){
                        score++;
                    } else if (c == ')') {
                        score--;
                    }

                    if(score < 0){
                        res = "NO";
                        break;
                    }
                }

                if (score != 0){
                    res = "NO";
                }
            }
            System.out.println(res);
        }
    }
}
