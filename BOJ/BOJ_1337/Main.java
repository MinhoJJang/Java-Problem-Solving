//package BOJ_1337;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int answer = 4;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(sc.nextLine()));
        }

        for (int i : list) {
            int[] find = new int[] { i + 1, i + 2, i + 3, i + 4 };
            int need = 4;
            for (Integer f : find) {
                if (list.contains(f)) need--;
            }
            answer = Math.min(answer, need);
        }

        System.out.println(answer);
    }
}
