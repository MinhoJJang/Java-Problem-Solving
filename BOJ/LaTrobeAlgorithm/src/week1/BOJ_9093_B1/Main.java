package week1.BOJ_9093_B1;

import java.util.Scanner;

public class Main {

    static String reverseString(String str) {
        char[] str_to_char = str.toCharArray();
        String returnString = "";
        int len = str_to_char.length;
        for (int i = len - 1; i >= 0; i--) {
            returnString += str_to_char[i];
        }
        return returnString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            String[] line_split = line.split(" ");
            String answerString = "";
            for (String s : line_split) {
                answerString += reverseString(s);
                answerString += " ";
            }
            System.out.println(answerString);
        }
    }
}
