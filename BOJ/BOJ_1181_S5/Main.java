package BOJ_1181_S5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            words.add(word);
        }
        /*
        Point 1. 오답 원인

        int N = sc.nextInt();

        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            words.add(word);
        }

        이렇게 하면 word에 N개의 값이 들어올 것 같지만 놀랍게도 아니다.
        N-1개의 word만 받는다

        nextInt()를 사용하면 정수를 입력 받고 나서 입력 버퍼에는 개행 문자가 남습니다. 그런데 nextInt() 자체는 숫자만 읽어들이고 그 뒤에 오는 개행 문자는 건드리지 않습니다. 이어서 nextLine()을 호출하면, 앞서 nextInt()로 인해 버퍼에 남아있던 개행 문자를 바로 읽어버려서, 마치 사용자가 아무것도 입력하지 않고 엔터만 친 것처럼 처리되고 맙니다. 그 결과, 첫 nextLine() 호출이 실제로 사용자의 입력을 받기 전에 개행 문자를 읽어버리면서, 생각했던 것보다 하나 적은 N-1개의 문자열만 입력 받게 되는 거죠.

        이 문제를 해결하려면, nextInt() 다음에 바로 nextLine()을 한 번 호출해서 남아있는 개행 문자를 소비해줘야 합니다. 그러면 사용자가 의도한 대로 문자열 입력을 제대로 받을 수 있게 됩니다.
         */

        // 길이에 따라 먼저 정렬하고, 길이가 같은 경우 사전순으로 정렬
        Collections.sort(words, (o1, o2) -> {
            // 길이 비교
            int lengthCompare = Integer.compare(o1.length(), o2.length());
            // 길이가 같으면 사전순 비교
            if (lengthCompare == 0) {
                return o1.compareTo(o2);
            }
            return lengthCompare;
        });

        String temp_before = "";

        // 정렬된 단어 출력, 만약 이전 단어와 지금 출력하려는 단어가 같을 경우 패스
        for (String word : words) {
            if(temp_before.equals(word)){
                continue;
            }
            System.out.println(word);
            temp_before = word;
        }
    }
}
