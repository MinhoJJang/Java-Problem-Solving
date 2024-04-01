package week3.BOJ_7662_G4;
import java.io.*;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> tm = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                String operation = input[0];
                long number = Long.parseLong(input[1]);

                if ("I".equals(operation)) {
                    /** tm.getOrDefault(number, 0) + 1
                     *  이렇게 넣어야 하는 이유:
                     *
                     *  저걸 안하고 그냥 put을 해버리면, map에서는 같은 key 값을 가진 이상
                     *  그냥 업데이트를 해버린다.
                     *  그럼 이 업데이트 로직을 사용해, 같은 key가 여러번 등장할 경우
                     *  value에 등장 횟수를 적으면 되지 않을까?
                     *
                     *  즉, number(key) : 0(default)+1 을 해주는 이유는
                     *  저 value 값이 곧 number의 등장 횟수이기 때문이다.
                     */

                    tm.put(number, tm.getOrDefault(number, 0) + 1);
                } else if ("D".equals(operation)) {
                    if (!tm.isEmpty()) { // map이 비었으면 연산 안해도 됨
                        if (number == -1) {
                            // 최솟값 삭제
                            long firstKey = tm.firstKey();
                            if (tm.get(firstKey) == 1) {
                                // 1개면 그냥 빼버리면 된다.
                                tm.pollFirstEntry();
                            } else {
                                /**
                                 * key에 대해 value가 1초과라는 사실은
                                 * 이 key가 여러번 등장했음을 시사한다.
                                 * 근데 여기서 만약 그냥 poll을 해버린다?
                                 * 그 key값의 등장횟수와는 상관없이 poll 되어 버린다.
                                 *
                                 * 즉 key 등장횟수가 2회 이상이면
                                 * put을 이용해서 "업데이트" 를 해주는 것이다!!!!
                                 */

                                tm.put(firstKey, tm.get(firstKey) - 1);
                            }
                        } else {
                            // 최댓값 삭제
                            long lastKey = tm.lastKey();
                            if (tm.get(lastKey) == 1) {
                                tm.pollLastEntry();
                            } else {
                                tm.put(lastKey, tm.get(lastKey) - 1);
                            }
                        }
                    }
                }
            }

            if (tm.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(tm.lastKey() + " " + tm.firstKey());
            }
        }
    }
}
