package BOJ_2588_B3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int submul_3 = A * (B % 10);
        int submul_4 = A * ((B/10) % 10);
        int submul_5 = A * (B/100);

        int total = submul_3 + submul_4*10 + submul_5*100;

        System.out.println(submul_3);
        System.out.println(submul_4);
        System.out.println(submul_5);
        System.out.println(total);
    }
}
