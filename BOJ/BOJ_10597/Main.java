package BOJ_10597;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[] able;
    static ArrayList<ArrayList<Integer>> list;
    static int N;
    static String str;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();
        N = str.length();
        if (N > 9)
            N = (N - 9) / 2 + 9;

        list = new ArrayList<>();
        arr = new int[N + 1];
        able = new int[str.length() + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            String target = String.valueOf(i);
            int idx = str.indexOf(target);
            while (idx >= 0) {
                list.get(i).add(idx); // 찾은 자리를 저장한다
                arr[i]++;
                idx = str.indexOf(target, idx + 1);
            }
        }

        Arrays.sort(arr);
        findNext(N);
    }

    static void print() {
        for (int i = 0; i < str.length(); i++) {
            int num = able[i];
            if (num >= 10)
                i++;
            System.out.print(num + " ");
        }
    }

    static void findNext(int n) {
        if (n == 0) {
            print();
            System.exit(0);
        }

        boolean isBanned = false;

        for (int index : list.get(n)) {
            if (n >= 10 && able[index] == 0 && able[index + 1] == 0) {
                isBanned = true;
                able[index] = n;
                able[index + 1] = n;
                findNext(n - 1);
                able[index] = 0;
                able[index + 1] = 0;
            } else if (able[index] == 0) {
                isBanned = true;
                able[index] = n;
                findNext(n - 1);
                able[index] = 0;
            }
        }

        if(!isBanned){
            findNext(n - 1);
        }
    }
}

