package week1.BOJ_12605_B2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] line_split = line.split(" ");
            int len = line_split.length;
            String newLine = "";
            for (int j = len - 1; j >= 0; j--) {
                newLine += line_split[j];
                newLine += " ";
            }
            System.out.println("Case #" + (i + 1) + ": " + newLine);
        }
    }
}
