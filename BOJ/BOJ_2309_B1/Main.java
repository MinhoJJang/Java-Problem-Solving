package src.BOJ_2309_B1;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int num = 9; // 난쟁이 수
    static final int max = 100; // 난쟁이 키 합

    static void printAnswer(int i, int j, int[] arr){
        for (int k = 0; k < num; k++) {
            if(k != i && k != j){
                System.out.println(arr[k]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] height = new int[num];
        int sum = 0;

        for (int i = 0; i < num; i++) {
            height[i] = sc.nextInt();
            sum+=height[i];
        }

        Arrays.sort(height);

        int checkSum = sum - 100; // 찾아야할 키 합(두 명분의 키를 빼면 된다)
        for (int i = 0; i < num-1; i++) {
            for (int j = i+1; j < num; j++) {
                if(height[i]+height[j] == checkSum){
                    printAnswer(i,j,height);
                    return;
                }
            }
        }
    }
}
