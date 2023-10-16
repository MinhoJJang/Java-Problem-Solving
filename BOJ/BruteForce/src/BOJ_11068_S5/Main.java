package BOJ_11068_S5;

import java.util.Scanner;

public class Main {

    static final int TWO = 2;
    static final int SIXTY_FOUR = 64;
    static final int CIRCULAR = 1;
    static final int NOT_CIRCULAR = 0;

    static String convertNumberSystem(String str, int B) {
        String convertedString = "";
        int dividend = Integer.parseInt(str);
        int divider = B;

        while (dividend > 0) {
            int remainder = dividend % divider;
            dividend /= divider;
            if (remainder >= 10) {
                convertedString += (char) (remainder + 55);
            } else {
                convertedString += remainder;
            }
        }

        return convertedString;
    }

    static int checkItIsCircularString(String str) {
        String reverseStr = String.valueOf(new StringBuilder(str).reverse());
        if (str.equals(reverseStr)) {
            return CIRCULAR;
        }
        return NOT_CIRCULAR;
    }

    static void printAnswer(int[] answer) {
        int len = answer.length;
        for (int i = 0; i < len; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] answer = new int[T];
        String num;

        for (int i = 0; i < T; i++) {
            num = sc.next();
            int flag = NOT_CIRCULAR;
            for (int B = TWO; B <= SIXTY_FOUR; B++) {
                flag = checkItIsCircularString(convertNumberSystem(num, B));
                if (flag == CIRCULAR) {
                    break;
                }
            }
            answer[i] = flag;
        }
        printAnswer(answer);

    }
}
