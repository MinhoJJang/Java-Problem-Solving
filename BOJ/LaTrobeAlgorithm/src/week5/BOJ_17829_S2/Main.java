package week5.BOJ_17829_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int findSecond(ArrayList<Integer> temp) {
        Collections.sort(temp);
        return temp.get(2);
    }

    static int pulling222(int[][] arr) {
        int len = arr.length;
        if (len == 2) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    temp.add(arr[i][j]);
                }
            }
            return findSecond(temp);
        } else {
            int[][] newarr = new int[len / 2][len / 2];
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < len; j += 2) {
                for (int k = 0; k < len; k += 2) {
                    // 시작 축이 j, 그다음 축이 k
                    temp.add(arr[j][k]);
                    temp.add(arr[j][k + 1]);
                    temp.add(arr[j + 1][k]);
                    temp.add(arr[j + 1][k + 1]);
                    newarr[j / 2][k / 2] = findSecond(temp);
                    temp.clear();
                }
            }
            return pulling222(newarr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(pulling222(arr));
    }
}
