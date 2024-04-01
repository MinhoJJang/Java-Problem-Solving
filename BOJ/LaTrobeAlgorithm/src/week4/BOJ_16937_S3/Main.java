package week4.BOJ_16937_S3;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int maxSize = 0;

    static boolean isAvailable(int H, int W, int a, int b) {
        if ((a <= H && b <= W) || (a <= W && b <= H)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H, W, N;
        ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> stickers = new ArrayList<>();
        H = sc.nextInt();
        W = sc.nextInt();
        sc.nextLine();
        N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            stickers.add(new AbstractMap.SimpleEntry<>(sc.nextInt(), sc.nextInt()));
        }

        // 스티커를 하나씩 돈다
        for (int i = 0; i < N; i++) {

            int h1 = stickers.get(i).getKey();
            int w1 = stickers.get(i).getValue();
            // 만약 이 스티커가 붙여질 수 없으면, 다음으로 패스한다.
            if (!isAvailable(H, W, h1, w1)) {
                continue;
            }

            for (int j = i + 1; j < N; j++) {
                int h2 = stickers.get(j).getKey();
                int w2 = stickers.get(j).getValue();
                if (!isAvailable(H, W, h2, w2)) {
                    continue;
                }

                /**
                 * 여기까지 온 이상 두 스티커는 모두 유효한 상태이다.
                 * 1. h1+h2 , w1?w2
                 * 2. h1+w2 , w1?h2
                 * 3. w1+w2 , h1?h2
                 * 4. w1+h2 , h1?w2
                 */
                int max;
                if (isAvailable(H, W, h1 + h2, max = w1 > w2 ? w1 : w2) || isAvailable(H, W, h1 + w2, max = w1 > h2 ? w1 : h2) || isAvailable(H, W, w1 + w2, max = h1 > h2 ? h1 : h2) || isAvailable(H, W, w1 + h2, max = h1 > w2 ? h1 : w2)) {
                    int localSize = h1 * w1 + h2 * w2;
                    if (maxSize < localSize) {
                        maxSize = localSize;
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
