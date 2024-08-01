package src.BOJ_10448_B1;

import java.util.Scanner;

public class Main {
    static int n = 45;
    static int T;
    static int idx = 0;
    static int TRIANGLE_NUMBER = 1;
    static int[] tri = new int[n];

    static void fn(int num, int[] answer){
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if(tri[i] + tri[j] + tri[k] == num) {
                        answer[idx] = TRIANGLE_NUMBER;
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int k = n;
        int[] answer = new int[T];
        while(k > 0){
            tri[k-1] = k*(k+1)/2;
            k--;
        }

        for (int i = 0; i < T; i++) {
            fn(sc.nextInt(), answer);
            idx++;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
}
