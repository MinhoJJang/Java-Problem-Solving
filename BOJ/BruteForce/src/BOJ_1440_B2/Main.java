package BOJ_1440_B2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(":");
        int[] arr_int = new int[arr.length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr_int[i] = Integer.parseInt(arr[i]);
            if(arr_int[i] > 0 && arr_int[i] <= 12){
                count++;
            }
            if(arr_int[i] >= 60){
                System.out.println(0);
                return;
            }
        }

        System.out.println(count*2);
    }
}
