package week5.BOJ_18511_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        String factors = br.readLine().replaceAll(" ", "");
        for (Integer i = N; i >= 0; i--) {

            char[] arr = i.toString().toCharArray();

            /**
             * 기존 코드가 시간초과가 난 이유
             * 위 for문에서 최대 1억번 반복하고
             * 아래 for문에서 N 자리수만큼 반복하니까
             * 최대 10억 반복한다
             * 즉 10초가 걸린다
             */

            int cnt = 0;
            for (Character c : arr) {
                // K원소 안에 c가 있을 경우
                if (factors.contains(c.toString())) {
                    cnt++;
                }
            }
            if (cnt == arr.length) {
                System.out.println(i);
                break;
            }
        }

    }
}
