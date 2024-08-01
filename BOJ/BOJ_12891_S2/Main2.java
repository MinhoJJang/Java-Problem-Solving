package week12.BOJ_12891_S2;

import java.io.*;
import java.util.*;

public class Main2 {

    static int cnt = 0; // total number of available password

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // total length
        int P = Integer.parseInt(st.nextToken()); // password length

        String str = br.readLine();
        int[] cond = new int[4];
        char[] DNA = new char[]{'A', 'C', 'G', 'T'};
        long[] cond_status = new long[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cond[i] = Integer.parseInt(st.nextToken());
        }

        // let me know the first string's status
        String start_string = str.substring(0, P);
        for (int i = 0; i < 4; i++) {
            cond_status[i] = countChar(start_string, DNA[i]);
        }
        passwordSafetyCheck(cond, cond_status);

        for (int i = 0; i < S - P; i++) {
            // sliding window에서 시작점과 끝 점만 체크하고 cond_status에 추가한다.
            char delete_char = str.charAt(i);
            char add_char = str.charAt(i + P);

            for (int j = 0; j < 4; j++) {
                if (DNA[j] != delete_char) continue;
                cond_status[j]--;
            }

            for (int j = 0; j < 4; j++) {
                if (DNA[j] != add_char) continue;
                cond_status[j]++;
            }

            passwordSafetyCheck(cond, cond_status);
        }

        System.out.println(cnt);
    }

    static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    static boolean passwordSafetyCheck(int[] cond, long[] cond_status) {
        for (int i = 0; i < 4; i++) {
            if (cond_status[i] >= cond[i]) continue;
            return false;
        }
        cnt++;
        return true;
    }
}
