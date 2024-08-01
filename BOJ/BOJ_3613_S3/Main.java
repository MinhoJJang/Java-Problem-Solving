package week2.BOJ_3613_S3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int init = -1;
    static final int java = 0;
    static final int cpp = 1;

    static final String err = "Error!";

    public static void main(String[] args) {

        // FIFO Queue!
        Queue<Character> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] input_arr = input.toCharArray();
        int len = input_arr.length;

        /** 1차 틀린이유: 첫 글자로 대문자 시 Error! 즉시 출력 안함
        /** 2차 틀린이유: '_' 의 여러가지 케이스 체크 안함
         * 1. 맨 앞, 뒤 문자가 _ 일 경우 에러
         * 2. _이 연속 2개 이상일 경우 에러
         */
        if (Character.isUpperCase(input_arr[0]) || input_arr[0] == '_' || input_arr[len-1] == '_') {
            System.out.println(err);
            return;
        }


        for (char c : input_arr) {
            q.add(c);
        }

        int type = init;
        int justBefore = init;
        StringBuilder sb = new StringBuilder();

        /**
         * 1. java 형식인지 C++ 형식인지 체크
         */
        while (!q.isEmpty()) {
            Character c = q.poll();
            /**
             * 만약 대문자 발견 type를 java로 변경
             * 만약 '_' 발견 시 type를 cpp로 변경
             *
             * 현재 문자열의 type에 따라 error 체크
             */
            if (Character.isUpperCase(c)) {
                if (type == init) {
                    type = java;
                } else if (type == cpp) {
                    sb.setLength(0);
                    sb.append(err);
                    break;
                }
                sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else if (c.equals('_')) {
                if (type == init) {
                    type = cpp;
                } else if (type == java || justBefore == cpp) {
                    sb.setLength(0);
                    sb.append(err);
                    break;
                }
                justBefore = cpp;
            } else {
                if (justBefore == cpp) {
                    sb.append(Character.toUpperCase(c));
                    justBefore = init;
                } else {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
    }
}
