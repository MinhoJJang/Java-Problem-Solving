package src.BOJ_11005_B1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static void printIntegerToASCII(String[] arr, int len, int B){
        if(B <= 10){
            for (int i = len; i >= 0; i--) {
                if(Integer.parseInt(arr[i]) == 0 && i == len){
                    continue;
                }
                System.out.print(arr[i]);
            }
        }
        else{
            for (int i = len; i >= 0; i--) {
                if(Integer.parseInt(arr[i]) == 0 && i == len){
                    continue;
                }

                if(Integer.parseInt(arr[i]) >= 10){
                    char cr = (char)(Integer.parseInt(arr[i])+55);
                    System.out.print(cr);
                }
                else{
                    System.out.print(arr[i]);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        // 최대 36진법까지
        // 숫자로 나타낼 수 없을 경우 A = 10 ... Z = 35
        /*
            2진법으로 10억 나타내기
            2의 30승 > 10억
            즉 진법변환된 수를 담는 배열에는 최대 29개의 칸이 있으면 된다.
         */
        String[] convertedNumArray = new String[31];
        Arrays.fill(convertedNumArray,"0");

        int convertedNumArrayLen = 0; // B 진수로 바꾸었을 때 숫자 길이 (Len이 1이면 실제 길이는 2이다. 배열은 0부터 시작하니)
        int max = (int) (Math.pow(B,convertedNumArrayLen) * (B-1)); // == B-1
        while (max < N) {
            convertedNumArrayLen++;
            max = (int) (Math.pow(B,convertedNumArrayLen) * (B-1));
        }

        int actualLen = convertedNumArrayLen;
        int divisor = (int) Math.pow(B, convertedNumArrayLen);

        while (convertedNumArrayLen >= 0) {
            convertedNumArray[convertedNumArrayLen] = String.valueOf(N / divisor);
            N -= Integer.parseInt(convertedNumArray[convertedNumArrayLen]) * divisor;
            if (N == 0) {
                break;
            } else {
                convertedNumArrayLen--;
                divisor = (int) Math.pow(B, convertedNumArrayLen);
            }
        }

        printIntegerToASCII(convertedNumArray, actualLen, B);
    }
}
// 맞았습니다