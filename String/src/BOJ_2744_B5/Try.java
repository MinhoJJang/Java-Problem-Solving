package BOJ_2744_B5;

import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        char[] str_toArr = str.toCharArray();

        for(int i = 0; i<len; i++){
            int ascii = str_toArr[i];
            if (ascii <= 90 && ascii >= 65) {
                str_toArr[i] = Character.toLowerCase(str_toArr[i]);
            }
            else if (ascii <= 122 && ascii >= 97) {
                str_toArr[i] = Character.toUpperCase(str_toArr[i]);
            }
        }

        str = new String(str_toArr);
        System.out.println(str);
    }
}