package week5.BOJ_2156_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /**
     * 배열 arr, idx 0,1,2,3,4,5 가 있다고 해보자
     * <p>
     * 5에서의 최댓값은, 5의 값 + ( 3에서의 최댓값 혹은 4에서의 연속X 값 )or 4까지의 max이다.
     * <p>
     * 근데 `4에서의 연속X 값 + 5의 value` 이 조건이 매우 복잡하다
     * 그래서 그냥 3을 지나지 않고 4를 와야 하니까
     * 2에서의 최댓값 + 4 를 해버리면 된다
     */
    static int n;
    static int[] memo;
    static int[] arr;
    static final int init = -1;

    static int findMax(int n) {

        if (memo[n] == init) {
            if (n < 3) {
                if (n == 0) {
                    memo[n] = arr[0];
                } else if (n == 1) {
                    memo[n] = arr[0] + arr[1];
                } else if (n == 2) {
                    int a = arr[0] + arr[1];
                    int b = arr[1] + arr[2];
                    int c = arr[0] + arr[2];
                    memo[n] = Math.max(Math.max(a, b), c);
                }
            } else {
                int a = memo[n - 3] + arr[n - 1] + arr[n];
                int b = memo[n - 2] + arr[n];
                int c = memo[n - 1];

                if (memo[n - 3] == init) {
                    a = findMax(n - 3) + arr[n - 1] + arr[n];
                }
                if (memo[n - 2] == init) {
                    b = findMax(n - 2) + arr[n];
                }
                if (memo[n - 1] == init) {
                    c = findMax(n - 1);
                }

                memo[n] = Math.max(Math.max(a, b), c);
            }
        }

        return memo[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new int[n];
        Arrays.fill(memo, init);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findMax(n - 1));
    }
}
