package BOJ_18185_D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int trio = 0;
        for (int i = 0; i < N - 2; i++) {

            int k = Math.min(Math.min(arr[i], arr[i + 1]), arr[i + 2]);
            int idx = i;

            if(k == arr[i])
        }


        /*

            arr[i] -= k;
            arr[i + 1] -= k;
            arr[i + 2] -= k;
            sum -= 3 * k;
            trio += 7 * k;
         */
        int duo = 0;
        for (int i = 0; i < N - 1; i ++) {
            int k = Math.min(arr[i], arr[i + 1]);
            if (k == 0) continue;
            arr[i] -= k;
            arr[i + 1] -= k;
            sum -= 2 * k;
            duo += 5 * k;
        }

        System.out.println(sum*3 + trio + duo);
    }
}
