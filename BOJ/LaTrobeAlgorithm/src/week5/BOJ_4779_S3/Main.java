package week5.BOJ_4779_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static String[] memo;
    static String init = " ";
    static StringBuilder sb = new StringBuilder();

    static String fn(int n) {

        if (memo[n].equals(init)) {
            if (n > 0) {
                int len = (int) Math.pow(3, n - 1);

                for (int i = 0; i < len; i++) {
                    sb.append(" ");
                }
                String between = String.valueOf(sb);
                sb.setLength(0);
                if (memo[n - 1].equals(init)) {
                    memo[n - 1] = fn(n - 1);
                }
                sb.append(memo[n - 1]).append(between).append(memo[n - 1]);
                memo[n] = String.valueOf(sb);
                sb.setLength(0);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        memo = new String[13];
        Arrays.fill(memo, init);
        memo[0] = "-";
        while (true) {
            s = br.readLine();
            if (s == null || s.isEmpty()) break; // 여기서 입력이 null이거나 비어있으면 반복을 종료.
            System.out.println(fn(Integer.parseInt(s)));
        }
    }
}
