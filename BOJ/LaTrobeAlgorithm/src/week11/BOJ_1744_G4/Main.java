package week11.BOJ_1744_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        int pos_cnt = 0;
        int neg_cnt = 0;

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val > 0) {
                positive.add(val);
                pos_cnt++;
            } else {
                negative.add(val);
                neg_cnt++;
            }
        }

        Collections.sort(positive, Comparator.reverseOrder());
        Collections.sort(negative);

        for (int i = 0; i < pos_cnt; i += 2) {
            if (i == pos_cnt - 1) {
                result += positive.get(i);
                continue;
            }

            int plus = positive.get(i) + positive.get(i + 1);
            int multiple = positive.get(i) * positive.get(i + 1);
            int biggerOne = multiple > plus ? multiple : plus;

            result += biggerOne;
        }

        for (int i = 0; i < neg_cnt; i += 2) {
            if (i == neg_cnt - 1) {
                result += negative.get(i);
                continue;
            }
            int plus = negative.get(i) + negative.get(i + 1);
            int multiple = negative.get(i) * negative.get(i + 1);
            int biggerOne = multiple > plus ? multiple : plus;
            result += biggerOne;
        }

        System.out.println(result);
    }
}
