package BOJ_2753_B5;

import java.util.Scanner;

public class Main {

    static int leap = 1;
    static int not_leap = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int flag = not_leap;

        if ((x % 4 == 0 && x % 100 != 0) || x % 400 == 0) {
            flag = leap;
        }

        System.out.println(flag);
    }
}
