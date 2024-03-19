package week2.BOJ_1357_B1;

import java.util.Scanner;

public class Main {

    static String Rev(String origin) {
        String result = "";

        char[] origin_arr = origin.toCharArray();
        int len = origin_arr.length;

        for (int i = len - 1; i >= 0; i--) {
            result += origin_arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String X = sc.next();
        String Y = sc.next();

        String res = Rev(String.valueOf(Integer.parseInt(Rev(X)) + Integer.parseInt(Rev(Y))));

        System.out.println(Integer.parseInt(res));
    }
}
