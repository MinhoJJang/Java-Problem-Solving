package week6.BOJ_1654_S2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long calculateSum(long mid, int[] tree, int N) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (tree[i]/ mid) > 0 ? tree[i] / mid : 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 가지고 있는 랜선 개수
        int N = sc.nextInt(); // 필요한 랜선의 개수
        sc.nextLine();
        int[] wires = new int[K];
        for (int i = 0; i < K; i++) {
            wires[i] = sc.nextInt();
            sc.nextLine();
        }

        long low = 1;
        long high = Arrays.stream(wires).max().getAsInt();
        long answer = low;
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = calculateSum(mid, wires, K);
            if (sum >= N) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
