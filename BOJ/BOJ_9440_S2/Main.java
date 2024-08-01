package week11.BOJ_9440_S2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        1. 오름차순 정렬
        2. 0부분만 따로 빼고
        3. 해당 정렬 문자열의 2번째 위치에 삽입한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            if (input.equals("0")) break;

            int N = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            arr.sort(Comparator.naturalOrder());

            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();

            // 맨 앞자리는 0이 되어서는 안된다.
            int point = 0;
            for (int i = 0; i < N; i++) {
                if (arr.get(i) != 0) {
                    point = i;
                    break;
                }
            }

            num1.append(arr.get(point));
            num2.append(arr.get(point + 1));

            arr.remove(point);
            arr.remove(point);

            int cnt = 0;
            for (Integer n : arr) {
                if (cnt % 2 == 0) {
                    num1.append(n);
                } else {
                    num2.append(n);
                }
                cnt++;
            }

            int a = Integer.parseInt(num1.toString());
            int b = Integer.parseInt(num2.toString());
            int result = a + b;

            bw.write(result + "\n");
        }

        bw.flush();
    }
}
