package BOJ_13223_B3;

import java.util.Scanner;

public class Main {

    static final int h = 0;
    static final int m = 1;
    static final int s = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();

        String[] first_time = first.split(":");
        String[] second_time = second.split(":");
        int[] need_time = {0,0,0};
        String[] need_time_str = {"00", "00", "00"};

        for(int i=h; i<=s; i++){
            need_time[i] = Integer.parseInt(second_time[i]) - Integer.parseInt(first_time[i]);

        }

        for(int i=s; i>=h; i--) {
            if(need_time[i] < 0 && i>=m){
                need_time[i]+=60;
                need_time[i-1]--;
            }

            if(need_time[i] < 0 && i==h){
                need_time[i] += 24;
            }

            if(need_time[h] == 0 && need_time[m] == 0 && need_time[s] == 0){
                need_time[h] += 24;
            }

            if(need_time[i] < 10) {
                need_time_str[i] = "0" + String.valueOf(need_time[i]);
            }
            else{
                need_time_str[i] = String.valueOf(need_time[i]);
            }
        }

        System.out.println(need_time_str[h] + ":" + need_time_str[m] + ":" + need_time_str[s]);
    }
}
