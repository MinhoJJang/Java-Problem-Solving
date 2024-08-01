package BOJ_10819_S2;

import java.util.Scanner;

public class Main {

    static int max_sum = 0;

    static void calculate_value(int[] arr){
        int len = arr.length;
        int local_sum = 0;
        for (int i = 0; i < len - 1; i++) {
            local_sum += Math.abs(arr[i] - arr[i+1]);
        }
        if(max_sum < local_sum){
            max_sum = local_sum;
        }
    }

    static void permute(int[] arr, int depth, int n) {
        if (depth == n) { // 길이가 n이면 순열 완성했으니까 해당 배열에 대해 값 구할 수 있음
            calculate_value(arr);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            permute(arr, depth + 1, n);
            swap(arr, i, depth); // 배열을 원래 상태로 복원
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        /**
         * 1. arr에 대해 가능한 모든 순열 만들기 -> 모르겠어서 답안 확인하였음
         * 2. 순열에 대해 문제에서 주어진 식의 값 구하기 (최댓값일 경우 값 변경) = calculate_value()
         */

        permute(arr, 0, N);
        System.out.println(max_sum);
    }
}
