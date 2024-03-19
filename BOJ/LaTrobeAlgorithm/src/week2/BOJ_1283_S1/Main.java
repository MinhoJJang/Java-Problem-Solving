package week2.BOJ_1283_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int init = -1;
    static final int located = 1;

    static String makeBigBracket(String s) {
        String first_str = s.substring(0, 1);
        String last_str = s.substring(1);

        return "[" + first_str + "]" + last_str;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[] loc = new int[26]; // a = 0, z = 25 단축키 지정 여부 확인 배열
        Arrays.fill(loc, init); // init

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            String option = sc.nextLine();
            String[] option_arr = option.split(" ");
            int len = option_arr.length;
            int flag = init;

            // 1. 옵션에서 단어의 첫 글자가 이미 단축키로 지정되어 있는지 체크한다.
            for (int j = 0; j < len; j++) {

                int c = option_arr[j].toLowerCase().charAt(0) - 97;

                if (loc[c] == init) {
                    loc[c] = located;
                    flag = located;
                    /** 단어를 []로 감싸주어야 함.
                     * 어차피 첫 글자이기 때문에
                     * 첫글자를 제외한 나머지 글자를 substring으로 떼어내고
                     * 첫글자에 괄호를 붙인 str을 붙여주면 된다.
                     */
                    option_arr[j] = makeBigBracket(option_arr[j]);
                    break;
                }
            }

            // 2. 모든 단어의 첫 글자가 이미 지정되었다면, 차례대로 순회
            if (flag != located) {
                for (int j = 0; j < len; j++) {
                    int idx = 0;
                    int sub_string_length = option_arr[j].length();
                    char[] option_char = option_arr[j].toCharArray();

                    for (int m = 1; m < sub_string_length; m++) {

                        char c = Character.toLowerCase(option_char[m]);
                        idx++;
                        if (loc[c - 97] == init) {
                            loc[c - 97] = located;
                            flag = located;
                            for (int k = 0; k < sub_string_length; k++) {
                                if (k == idx) {
                                    sb.append("[" + option_char[k] + "]");
                                } else {
                                    sb.append(option_char[k]);
                                }
                            }
                            option_arr[j] = String.valueOf(sb);
                            break;
                        }
                    }

                    if (flag == located) {
                        break;
                    }
                }
            }

            // 3. 이제 option_arr이 준비됐으니, 하나로 합쳐 String 으로 만든다.
            sb.setLength(0);
            for (int j = 0; j < len; j++) {
                sb.append(option_arr[j]);
                if (j != len - 1) {
                    sb.append(" ");
                }
            }

            System.out.println(sb);
        }

    }
}
