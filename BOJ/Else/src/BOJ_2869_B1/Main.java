package BOJ_2869_B1;

import java.util.Scanner;

public class Main {

    /**
     public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int A = sc.nextInt();
     int B = sc.nextInt();
     int V = sc.nextInt();
     int current_loc = 0;
     int day = 0;

     while (current_loc < V) {
     current_loc += A;
     day++;
     if (current_loc >= V) {
     break;
     }
     current_loc -= B;
     }
     System.out.println(day);
     }*/
    /**
     * 시간초과?
     * 0.25초구나..
     * 그럼 저렇게 더해서는 안된다는거네
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int day = (V - A) / (A - B) + 1;

        /** 만약에 A-B로 나누어떨어지지 않을 경우, 반드시 한번 더 올라가는 과정이 필요하게 된다.
         * 예를 들어 4 1 11 이라고 해보자. 실제로 올라가는데 4일이 걸린다.
         * V-A는 7, A-B는 3이다
         * 즉 (V-A)/(A-B) = 2가 나온다.
         * 하지만 2일만에 V-A를 모두 올라갈 수 없다. 나머지 1이 남기 때문이다.
         * 즉 나머지가 남는다는 소리는 한번 더 올라가야 한다는 의미가 되어서 아래 if문에서 day++를 해줘야만 한다.
         */

        if ((V - A) % (A - B) > 0) {
            day++;
        }

        System.out.println(day);
    }
}
