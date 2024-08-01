package week4.BOJ_17089_G5;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int minimum_friends = Integer.MAX_VALUE;

    public static void main(String[] args) {

        ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> every_relationships = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            every_relationships.add(new AbstractMap.SimpleEntry<>(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < M; i++) {
            AbstractMap.SimpleEntry<Integer, Integer> first_second_relation = every_relationships.get(i);
            int first_friend = first_second_relation.getKey();
            int second_friend = first_second_relation.getValue();

            ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> second_third_relationships = new ArrayList<>();

            for (AbstractMap.SimpleEntry<Integer, Integer> relation : every_relationships) {
                if (relation.getKey() == second_friend) {
                    second_third_relationships.add(relation);
                }
            }

            for (AbstractMap.SimpleEntry<Integer, Integer> relation : second_third_relationships) {
                int third_friend = relation.getValue();
                int local_friends = 0;

                // 내가 AbstractMap.SimpleEntry를 사용한 이유. contains를 사용하고싶어서 사용했음
                if (every_relationships.contains(new AbstractMap.SimpleEntry<>(third_friend, first_friend)) || every_relationships.contains(new AbstractMap.SimpleEntry<>(first_friend, third_friend))) {
                    // 세 친구 생성! 이제 서로의 친구 수만 모두 구하면 된다.
                    ArrayList<Integer> they_are_friends = new ArrayList<>();
                    they_are_friends.add(first_friend);
                    they_are_friends.add(second_friend);
                    they_are_friends.add(third_friend);

                    for (AbstractMap.SimpleEntry<Integer, Integer> friendship : every_relationships) {
                        // 친구 중 한명만 있어야함. 그래서 XOR ^
                        if ((they_are_friends.contains(friendship.getKey()) ^ they_are_friends.contains(friendship.getValue()))) {
                            local_friends++;
                        }
                    }

                    if (minimum_friends > local_friends) {
                        minimum_friends = local_friends;
                    }
                }
            }
        }


        if (minimum_friends == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minimum_friends);
        }
    }
}
