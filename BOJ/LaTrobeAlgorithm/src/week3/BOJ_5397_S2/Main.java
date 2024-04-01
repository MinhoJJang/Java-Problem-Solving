package week3.BOJ_5397_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            LinkedList<Character> password = new LinkedList<>();
            int cursor = 0; // 커서의 위치
            String input = br.readLine();
            char[] input_arr = input.toCharArray();

            for (int j = 0; j < input_arr.length; j++) {
                switch (input_arr[j]) {
                    case '<':
                        if (cursor > 0) cursor--;
                        break;
                    case '>':
                        if (cursor < password.size()) cursor++;
                        break;
                    case '-':
                        if (cursor > 0) {
                            password.remove(cursor - 1);
                            cursor--;
                        }
                        break;
                    default:
                        password.add(cursor, input_arr[j]);
                        cursor++;
                        break;
                }
            }

            System.out.println(password.stream().map(String::valueOf).collect(Collectors.joining()));
        }
    }
}
