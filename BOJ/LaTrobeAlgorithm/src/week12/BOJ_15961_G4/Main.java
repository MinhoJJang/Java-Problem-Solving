package week12.BOJ_15961_G4;

import java.io.*;
import java.util.*;

public class Main {

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        /*
         초밥 가짓수 d 만큼의 배열 생성
         int sushi_type[]

         항상 sushi_type[c] >= 1 이다.

         연속해서 먹는 접시 수 k

         회전 초밥이기 때문에 덱으로 한다
         슬라이딩 윈도우를 구현하기 위해 맨 처음 초밥을 뒤로 보낸다
         이 과정은 초밥 벨트에 놓인 접시 수 N번 수행해야 한다. 시작 초밥이 다르니까..
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            dq.add(Integer.parseInt(br.readLine()));
        }

        // the number of sushi type
        int[] type = new int[d + 1];

        // coupon number
        type[c] = 1;
        cnt = 1;

        // 덱의 앞쪽부터 k개 만큼의 초밥을 가져오고, 해당 번호를 num 이라 할 때 type[num]++ 을 해준다.
        // 이 때, type[num] 이 0이었다면 cnt++; 을 해준다
        Iterator<Integer> iterator = dq.iterator();
        int i = 0;
        while (iterator.hasNext() && i < k) {
            Integer sushi_num = iterator.next();
            if (type[sushi_num] == 0) cnt++;
            type[sushi_num]++;
            i++;
        }

        int max = cnt;

        // 이제 제대로 조사 시작
        for (int j = 0; j < N; j++) {
            // 먼저 dq에서 첫번째 값을 알아내자
            Integer first = dq.remove();
            // dq에서 k번째 값을 알아내야 한다. 새로 들어오는 값
            Integer last = getKthElement(dq, k);
            // dq에서 꺼낸 첫번째 값을 맨 뒤에 넣는다
            dq.offerLast(first);

            if (type[first] == 1) cnt--;
            type[first]--;
            if (type[last] == 0) cnt++;
            type[last]++;

            if (max < cnt) max = cnt;
        }

        System.out.println(max);
    }

    public static Integer getKthElement(Deque<Integer> deque, int k) {
        // k가 1보다 작거나 deque의 크기보다 크면 null 반환
        if (k < 1 || k > deque.size()) {
            return null;
        }

        // Iterator를 사용하여 Deque를 순회하며 k번째 요소 찾기
        Iterator<Integer> iterator = deque.iterator();
        Integer result = null;
        for (int i = 0; i < k; i++) {
            if (iterator.hasNext()) {
                result = iterator.next();
            } else {
                return null;
            }
        }
        return result;
    }
}