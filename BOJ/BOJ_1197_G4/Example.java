package week10.BOJ_1197_G4;

import java.util.*;

public class Example {
    static PriorityQueue<Map<Integer, Integer>> pq;

    public static void main(String[] args) {
        // Comparator를 제공하여 PriorityQueue 생성
        pq = new PriorityQueue<>(new Comparator<Map<Integer, Integer>>() {
            @Override
            public int compare(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
                // 예를 들어, 키 1의 값을 기준으로 정렬
                return Integer.compare(map1.get(2), map2.get(2));
            }
        });

        // 예시 데이터 추가
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 5);
        map1.put(2, 10);

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 3);
        map2.put(2, 15);

        pq.add(map1);
        pq.add(map2);

        // PriorityQueue에서 요소를 꺼내는 순서 확인
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
