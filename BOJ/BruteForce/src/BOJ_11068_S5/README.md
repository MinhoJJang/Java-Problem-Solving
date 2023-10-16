# 회문인 수

[문제 링크](https://www.acmicpc.net/problem/11068)

## 문제

<aside>
💡 어떤 수를 왼쪽부터 읽어도, 오른쪽부터 읽어도 같을 때 이 수를 회문인 수라고 한다. 예를 들어, 747은 회문인 수이다. 255도 회문인 수인데, 16진수로 표현하면 FF이기 때문이다. 양의 정수를 입력받았을 때, 이 수가 어떤 B진법 (2 ≤ B ≤ 64)으로 표현하면 회문이 되는 경우가 있는지 알려주는 프로그램을 작성하시오. B진법이란, 한 자리에서 수를 표현할 때 쓸 수 있는 수의 가짓수가 B라는 뜻이다. 예를 들어, 십진법에서 B는 10이다.

</aside>

## 입력

<aside>
💡 입력 데이터는 표준입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다. 입력의 첫 번째 줄에는 테스트 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터는 64 이상 1,000,000 이하인 하나의 정수로 주어진다.

</aside>

## 출력

<aside>
💡 출력은 표준출력을 사용한다. 하나의 테스트 데이터에 대한 답을 하나의 줄에 출력한다. 각 테스트 데이터에 대해, 주어진 수가 어떤 B진법 (2 ≤ B ≤ 64)으로 표현하여 회문이 될 수 있다면 1을, 그렇지 않다면 0을 출력한다.

</aside>

### 예제 입력

```
3
747
255
946734
```

### 예제 출력

```
1
1
0
```

# 풀이법 생각

<aside>
💡 1. 들어온 숫자를 2진법부터 64진법까지 계산한다
2. 계산 후 바로바로 회문인지 아닌지를 체크한다
3. 회문일경우 루프 종료 후 1 반환
4. 64까지 검사했는데 회문이 아니면 0 반환

</aside>

이전에 풀었던 [진법 변환 2](https://www.notion.so/2-618af77ff4884024a7cdd52ce8e42c66?pvs=21) 문제와 유사하다. 약간 조금 더 로직을 추가한 느낌?

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_11068_S5;

import java.util.Scanner;

public class Main {

    static final int TWO = 2;
    static final int SIXTY_FOUR = 64;
    static final int CIRCULAR = 1;
    static final int NOT_CIRCULAR = 0;

    static String convertNumberSystem(String str, int B) {
        String convertedString = "";
        int dividend = Integer.parseInt(str);
        int divider = B;

        while (dividend > 0) {
            int remainder = dividend % divider;
            dividend /= divider;
            if (remainder >= 10) {
                convertedString += (char) (remainder + 55);
            } else {
                convertedString += remainder;
            }
        }

        return convertedString;
    }

    static int checkItIsCircularString(String str) {
        String reverseStr = String.valueOf(new StringBuilder(str).reverse());
        if (str.equals(reverseStr)) {
            return CIRCULAR;
        }
        return NOT_CIRCULAR;
    }

    static void printAnswer(int[] answer) {
        int len = answer.length;
        for (int i = 0; i < len; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] answer = new int[T];
        String num;

        for (int i = 0; i < T; i++) {
            num = sc.next();
            int flag = NOT_CIRCULAR;
            for (int B = TWO; B <= SIXTY_FOUR; B++) {
                flag = checkItIsCircularString(convertNumberSystem(num, B));
                if (flag == CIRCULAR) {
                    break;
                }
            }
            answer[i] = flag;
        }
        printAnswer(answer);

    }
}
```

### 결과

```java
맞았습니다!
```

### 해결 방법 & 참고자료

# 정답 코드

```java
import java.util.Scanner;

class Main
{
    public static boolean isPalindromeInBase(int x, int base) {
        int[] digit = new int[20];
        int len = 0;
        while (x > 0) {
            digit[len++] = x % base;
            x /= base;
        }

        for (int i = 0; i < len / 2; i++)
            if (digit[i] != digit[len - i - 1])
                return false;
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int x = sc.nextInt();
            boolean ans = false;
            for (int i = 2; i <= 64; i++) {
                if (isPalindromeInBase(x, i)) {
                    ans = true;
                    break;
                }
            }
            System.out.println(ans ? 1 : 0);
        }
    }
}
```