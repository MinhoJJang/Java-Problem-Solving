package week3.BOJ_1436_S5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String end = "666";
        int num = 666;
        int cnt = 0;

        while (N != cnt) {
            if (String.valueOf(num).contains(end)) {
                cnt++;
            }
            num++;
        }

        System.out.println(num - 1);
    }
}
