package BOJ_1152_B2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splitStr = str.split(" ");
        int len = splitStr.length;

        if (len >= 2) {
            if (splitStr[len - 1].isBlank()) {
                len--;
            }
            if (splitStr[0].isBlank()) {
                len--;
            }
        }

        System.out.println(len);
    }
}

/**
 * 아 이런
 * 입력이 공백으로만 이루어진경우를 생각지못했다
 *  if (len >= 2)  조건을 추가해주자..
 */