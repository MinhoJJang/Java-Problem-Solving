package BOJ_1182_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int cnt = 0;

    static void findProgression(int N, int S, int depth, int currentSum, ArrayList<Integer> numbers) {

        if (depth == N) {
            if (S == currentSum) {
                cnt++;
            }
        } else if (depth < N) {
            findProgression(N, S, depth + 1, currentSum + numbers.get(depth), numbers);
            findProgression(N, S, depth + 1, currentSum, numbers);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NS = br.readLine().split(" ");
        String[] numbers_str = br.readLine().split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String num : numbers_str) {
            numbers.add(Integer.valueOf(num));
        }
        findProgression(Integer.parseInt(NS[0]), Integer.parseInt(NS[1]), 0, 0, numbers);
        if (Integer.parseInt(NS[1]) == 0 && cnt > 0) {
            cnt--;
        }
        System.out.println(cnt);
    }
}
