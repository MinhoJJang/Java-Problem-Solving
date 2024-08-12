//package BOJ_22994;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int ni = Integer.parseInt(input[0]);
        int mj = Integer.parseInt(input[1]);
        char[][] img = new char[ni][mj];

        StringBuilder sb = new StringBuilder();

        String[] height = new String[mj];
        Arrays.fill(height, "");
        String[] width = new String[ni];
        for (int i = 0; i < ni; i++) {
            img[i] = br.readLine().toCharArray();
            for (int j = 0; j < mj; j++) {
                height[j] += img[i][j];
            }
            width[i] = String.valueOf(img[i]);
        }

        int i = 1;
        int j = 1;
        int m = mj;
        int n = ni;

        for (int div = mj; div >= 2; div--) {
            if (mj % div != 0)
                continue;
            boolean flag = true;
            for (int idx = 0; idx < width.length; idx++) {

                for (int q = 0; q < mj; q += div) {
                    String s = width[idx].substring(q, q + div);
                    // s가 모두 같은 문자로 이루어져 있어야 함
                    char[] c = s.toCharArray();
                    char p = c[0];
                    flag = true;
                    for (int k = 0; k < c.length; k++) {
                        if (p != c[k]) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag)
                        break;
                }

                if (!flag)
                    break;
            }

            if (flag) {
                j = div;
                m = mj / div;
                break;
            }
        }

        for (int div = ni; div >= 2; div--) {
            if (ni % div != 0)
                continue;
            boolean flag = true;
            for (int idx = 0; idx < height.length; idx++) {
                for (int q = 0; q < ni; q += div) {

                    String s = height[idx].substring(q, q + div);
                    // s가 모두 같은 문자로 이루어져 있어야 함
                    char[] c = s.toCharArray();
                    char p = c[0];
                    flag = true;

                    for (int k = 0; k < c.length; k++) {
                        if (p != c[k]) {
                            flag = false;
                            break;
                        }
                    }

                    if (!flag)
                        break;
                }
                if (!flag)
                    break;
            }

            if (flag) {
                i = div;
                n = ni / div;
                break;
            }
        }

        char[][] origin = new char[n][m];

        for (int k = 0; k < n; k++) {
            for (int v = 0; v < m; v++) {
                origin[k][v] = img[k * i][v * j];
            }
        }

        System.out.println(n + " " + m);
        for (int k = 0; k < origin.length; k++) {
            System.out.println(origin[k]);
        }

    }
}
