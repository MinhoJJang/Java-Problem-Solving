package week11.BOJ_1339_G4;

import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] alphabet = new int[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] str_arr = br.readLine().toCharArray();
            for (int j = 0; j < str_arr.length; j++) {
                alphabet[str_arr[j] - 'A'] += Math.pow(10, str_arr.length - j - 1);
            }
        }

        Arrays.sort(alphabet);
        for (int j = 25; j > 16; j--) {
            max += alphabet[j] * (j - 16);
        }

        System.out.println(max);
    }
}
