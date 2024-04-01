package week3.BOJ_19583_S2;

import java.io.*;
import java.util.HashSet;

public class Main {


    static final int start = 0;
    static final int finish = 1;
    static final int finsih_steam = 2;

    static final int chat_time = 0;
    static final int user = 1;

    public static void main(String[] args) throws IOException {


        /**
         * time <= S 인 모든 사람 = 입장
         *
         * E <= time <= Q 인 모든 사람 = 퇴장
         *
         * 채팅은 여러번 칠 수 있으니까 시간대로 입력으 구분한다
         *
         * 1. time <= S
         *  입장시간 전에 친 사람을 받을 경우 set에 저장한다.
         * 2. S < time < E
         *  무시한다
         * 3. E<= time <= Q
         *  기존 set 에 있으면 cnt++;
         */

        HashSet<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] time = br.readLine().split(" ");
        int cnt = 0;
        String input = "";
        while ((input = br.readLine()) != null && !input.isBlank()) {
            String[] info = input.split(" ");
            if (info[chat_time].compareTo(time[start]) <= 0) {
                set.add(info[user]);
            } else if (info[chat_time].compareTo(time[finish]) >= 0 && info[chat_time].compareTo(time[finsih_steam]) <= 0) {
                if (set.contains(info[user])) {
                    cnt++;
                    set.remove(info[user]);
                }
            }
        }

        System.out.println(cnt);
    }
}
