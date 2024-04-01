package week4.BOJ_1083_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        for (String s : input) {
            list.add(Integer.parseInt(s));
        }

        // 이제 list에서 가장 큰 값의 위치를 알아야한다.
        LinkedList<Integer> sorted_list;
        ArrayList<Integer> answer_list = new ArrayList<>();
        sorted_list = (LinkedList<Integer>) list.clone();
        Collections.sort(sorted_list, Collections.reverseOrder());

        while (S > 0) {
            if (sorted_list.isEmpty()) {
                break;
            }

            for (Integer local_max : sorted_list) {

                // 먼저, local_max에 대해 list에서 위치를 찾는다.
                int location = list.indexOf(local_max);

                // 만약, location이 S보다 작거나 같다면, 우린 local_max 값을 앞으로 땡길 수 있다.
                if (location <= S) {
                    list.remove(local_max);
                    answer_list.add(local_max);
                    S -= location;
                    // 여기서, for문을 탈출하고, sorted_list을 재배치한다.
                    sorted_list.remove(local_max);
                    break;
                }
            }
        }

        answer_list.addAll(list);

        for (Integer n : answer_list) {
            System.out.print(n + " ");
        }

    }
}
