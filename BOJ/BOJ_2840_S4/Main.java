package src.BOJ_2840_S4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 바퀴의 칸 수
        int K = sc.nextInt(); // 바퀴를 돌리는 횟수

        int[] changed = new int[K]; // 글자가 바뀐 횟수
        String words = "";
        char[] character = new char[K]; // 회전이 멈췄을 때 가리키던 글자

        for (int i = 0; i < K; i++) {
            changed[i] = sc.nextInt();
            words += sc.next();
        }
        character = words.toCharArray();

        System.out.println(N);
        System.out.println(K);
        System.out.println(changed);
        System.out.println(character);
    }
}
