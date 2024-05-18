package week8.BOJ_12851_G4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] time = new int[100001]; // 점 위치 최소 시간 정보
    static int[] cnt = new int[100001]; // 점 위치 최소 시간,방법 수 정보
    static Queue<Integer> queue = new LinkedList<>();
    static int[] tp = new int[]{-1, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Arrays.fill(time, Integer.MAX_VALUE);
        Arrays.fill(cnt, 1);

        // 1. 만약 N == K 라면 0초이다
        if (N == K) {
            time[K] = 0;
        }
        // 2. 만약 K < N 이라면, 수빈이는 뒤로 1칸씩 움직이는 수 밖에 없다.
        else if (K < N) {
            time[K] = N - K;
        }
        // 3. 이제 진짜 숨바꼭질 시작해보자
        else {
            queue.add(N);
            time[N] = 0;
            find();
        }

        System.out.println(time[K]);
        System.out.println(cnt[K]);
    }

    private static void find() {
        while (!queue.isEmpty()) {
            int current_loc = queue.poll();
            int[] next_loc = new int[]{current_loc + tp[0], current_loc + tp[1], current_loc * tp[2]};

            for (int next : next_loc){
                if(isVaild(next)){
                    // 1. 만약 처음 가는 곳이라면 값을 새로 초기화
                    if(time[next] == Integer.MAX_VALUE){
                        time[next] = time[current_loc] + 1;

                        // 문제의 핵심 포인트!!!!!!!!!!!!!!!!!!!!!
                        cnt[next] = cnt[current_loc];
                        queue.add(next);
                    }
                    // 2. 만약 방문했던 곳인데, 최소 시간이 같다면 cnt up
                    else if(time[next] == time[current_loc] + 1){

                        // 문제의 핵심 포인트!!!!!!!!!!!!!!!!!!!!!
                        cnt[next] += cnt[current_loc];
                    }
                }
            }
        }
    }

    private static boolean isVaild(int n) {
        if (0 <= n && n <= 100000) {
            return true;
        }
        return false;
    }
}

/*
반례

1 14

정답
5
4

1 2 4 8 7 14
1 2 3 6 7 14

이 반례는 1 7 에도 적용됨
이게 뭔 말이냐
cnt(방문 방법 수)가 전파된다는 것이다.
 */