package week6.BOJ_2805_S2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static long calculateSum(int mid, int[] tree, int N) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (tree[i] - mid) > 0 ? tree[i] - mid : 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }

        int low = 0;
        int high = Arrays.stream(trees).max().getAsInt();
        int answer = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = calculateSum(mid, trees, N);
            if (sum >= M) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}