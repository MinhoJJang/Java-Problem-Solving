package week1.BOJ_11023_B3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");
        int sum = 0;
        for (String s : str) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
    }
}
