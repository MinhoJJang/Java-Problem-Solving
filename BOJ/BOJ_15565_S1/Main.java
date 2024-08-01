package week12.BOJ_15565_S1;

import java.io.*;
import java.util.*;

// two pointer problem
public class Main {

    static final int lion = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // total number of doll
        int K = Integer.parseInt(st.nextToken()); // continuous number of doll

        int start = 0;
        int end = 0;
        int minimum_subset_size = -1;


        int[] collection = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            collection[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 라이언 인형 수
        int lion_size = isLion(collection, 0);
        int current_subset_size = 1;

        while (start < N && end < N && start <= end) {
            if (lion_size >= K) {
                if (minimum_subset_size == -1) {
                    minimum_subset_size = current_subset_size;
                } else {
                    minimum_subset_size = minimum_subset_size < current_subset_size ? minimum_subset_size : current_subset_size;
                }
                lion_size -= isLion(collection, start);
                start += 1;
                current_subset_size -= 1;
            } else if (lion_size < K) { // 라이언이 부족할경우
                end += 1;
                current_subset_size += 1;
                lion_size += isLion(collection, end);
            }
        }

        System.out.println(minimum_subset_size);

    }

    // 해당 번호가 라이언인지 아닌지
    private static int isLion(int[] collection, int idx) {
        if (collection[idx] == lion) return 1;
        else return 0;
    }
}
