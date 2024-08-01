package week5.BOJ_18511_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int N, max = Integer.MIN_VALUE;
    static int[] K;

    static void findMax(int number) {
        if (number > N) {
            return;
        }
        max = Math.max(max, number);

        for (int i = 0; i < K.length; i++) {
            int nextNumber = number * 10 + K[i];
            findMax(nextNumber);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K_size = Integer.parseInt(st.nextToken());

        K = new int[K_size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K_size; i++) {
            K[i] = Integer.parseInt(st.nextToken());
        }

        findMax(0);
        System.out.println(max);
    }
}
