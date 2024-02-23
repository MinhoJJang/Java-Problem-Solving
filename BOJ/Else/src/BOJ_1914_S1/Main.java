package BOJ_1914_S1;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static int max_N = 100;

    static String[] memo = new String[max_N + 1];

    static String recursive(int N) {
        if (memo[N] == null) {
            if (N == 1) {
                memo[N] = "13";
            } else if (N == 2) {
                memo[N] = "121323";
            } else {
                String temp = recursive(N - 2) + "12" + string_shift(recursive(N - 2), 2);
                memo[N] = temp + "13" + string_shift(temp, 1);
            }
        }
        return memo[N];
    }

    static String string_shift(String str, int shift) {

        char[] str_to_char = str.toCharArray();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            str_to_char[i] += shift;
            if (str_to_char[i] > 51) {
                str_to_char[i] -= 3;
            }
        }

        return new String(str_to_char);
        // Point 1. 처음에 str_to_char.toString() 했는데 이상하게 나와서 new String(str_to_char) 로 했더니 잘 나온다.
        /*
        차이점은 다음과 같다.

        1. str_to_char.toString()
        toString()을 Spring DTO 만들 때 엔티티값 불러오는 용도로 사용했더니 원래 용도를 까먹어버린거같다. 원래 용도는 해당 객체의 클래스이름, @기호, 해시코드 16진수 표현을 합친 문자열을 반환한다. 즉 char 배열의 내용을 출력하는게 아니라, 배열 객체의 참조 정보를 반환한다.

        2. new String(str_to_char)
        char[] 배열을 받아 새로운 String 객체를 생성한다. 결과적으로, new String(str_to_char)는 char 배열의 내용을 기반으로 하는 새로운 문자열을 생성하고 반환한다.

         이걸 이제야 알았다고....?
         */
    }

    static void string_print(String str) {

        char[] str_to_char = str.toCharArray();
        int length = str.length();

        for (int i = 0; i < length; i += 2) {
            System.out.println(str_to_char[i] + " " + str_to_char[i + 1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 일단 원판을 옮기는 개수를 저장하자. 옮긴 횟수는 K이고 K = 2^N - 1 
        String[] K = new String[max_N + 1];
        for (int i = 1; i <= max_N; i++) {
            // 2의 i제곱을 계산하고 1을 빼는 연산을 BigInteger를 사용해 수행
            BigInteger value = BigInteger.valueOf(2).pow(i).subtract(BigInteger.ONE);
            K[i] = value.toString();
        }
        // Point 2. 2^100은 당연히 int 범위를 아득히초과한다. K의 타입을 String으로 바꿔주자.
        // Point 3. String이 문제가 아니다. 애초에 pow(2, i)는 double이고 이는 매우 큰 정수값을 정확하게 표현할 수 없다. 이를 위해 자바에 존재하는 BigInteger을 사용하자.

        // 원판을 옮기는 횟수
        System.out.println(K[N]);

        // N<= 20인 경우 원판 옮기는 순서를 나열한다
        if (N <= 20) {
            string_print(recursive(N));
        }

    }
}
