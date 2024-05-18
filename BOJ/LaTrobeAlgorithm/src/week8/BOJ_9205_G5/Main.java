package week8.BOJ_9205_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // 편의점개수
            int n = Integer.parseInt(br.readLine());
            List<AbstractMap.SimpleEntry<Integer, Integer>> store_list = new ArrayList<>();
            List<AbstractMap.SimpleEntry<Integer, Integer>> visit_list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 시작점 저장
            AbstractMap.SimpleEntry<Integer, Integer> starting_point = new AbstractMap.SimpleEntry<>(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            store_list.add(starting_point);

            // 편의점 위치 저장
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                store_list.add(new AbstractMap.SimpleEntry<>(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            // 도착지 저장
            st = new StringTokenizer(br.readLine());
            AbstractMap.SimpleEntry<Integer, Integer> end_point = new AbstractMap.SimpleEntry<>(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 일단 도착지에서 시작한다.
            Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
            queue.add(end_point);
            visit_list.add(end_point);

            String mood = "sad";

            // 도착지에서 List를 돌면서 범위 내에 있는지 체크한다.
            while (!queue.isEmpty()) {
                AbstractMap.SimpleEntry<Integer, Integer> current_loc = queue.poll();
                if (current_loc.equals(starting_point)) {
                    mood = "happy";
                    break;
                }
                for (AbstractMap.SimpleEntry<Integer, Integer> store : store_list) {
                    if (isValid(current_loc, store, visit_list)) {
                        // current_loc에 대해 store이 1000m 내에 있을 경우
                        queue.add(store);
                        visit_list.add(store);
                    }
                }
            }

            System.out.println(mood);
        }
    }

    private static boolean isValid(AbstractMap.SimpleEntry<Integer, Integer> currentLoc, AbstractMap.SimpleEntry<Integer, Integer> store, List<AbstractMap.SimpleEntry<Integer, Integer>> visitList) {
        // x축 차이 절댓값 + y축 차이 절댓값이 1000 이하여야 함
        if ((Math.abs(currentLoc.getKey() - store.getKey()) + Math.abs(currentLoc.getValue() - store.getValue())) <= 1000 && !visitList.contains(store)) {
            return true;
        }
        return false;
    }
}
