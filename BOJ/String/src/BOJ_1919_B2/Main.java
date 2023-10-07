package BOJ_1919_B2;

import java.util.Scanner;

// 소문자이므로 97 = a, 122 = z

public class Main {

    final static int alphabet = 26;

    public static void setArr(String str, int[] arr){
        char[] str_to_char_arr = str.toCharArray();
        int len = str.length();
        for(int i=0; i<len; i++){
            int ascii = str_to_char_arr[i];
            arr[ascii-97]++;
        }
    }

    public static int differenceSum(int[] arr1, int[] arr2){
        int sum = 0;
        for(int i=0; i<alphabet; i++){
            sum += Math.abs(arr1[i] - arr2[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int numberOfDeletedCharacter = 0;

        int[] str1_arr = new int[alphabet];
        int[] str2_arr = new int[alphabet];

        setArr(str1, str1_arr);
        setArr(str2, str2_arr);
        numberOfDeletedCharacter = differenceSum(str1_arr, str2_arr);

        System.out.println(numberOfDeletedCharacter);

    }
}
