package week1.BOJ_11024_B3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(" ");
            int sum = 0;
            for (String s : str) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}
