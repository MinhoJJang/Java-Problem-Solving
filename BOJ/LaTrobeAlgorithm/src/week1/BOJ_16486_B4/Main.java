package week1.BOJ_16486_B4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        final double pi = 3.141592D;

        System.out.println(d1*2 + 2*d2*pi);
    }
}
