# **진법 변환 2**

[문제 링크](https://www.acmicpc.net/problem/11005)

## 문제

<aside>
💡 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

</aside>

## 입력

<aside>
💡 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

</aside>

## 출력

<aside>
💡 첫째 줄에 10진법 수 N을 B진법으로 출력한다.

</aside>

### 예제 입력

```
60466175 36
```

### 예제 출력

```
ZZZZZ
```

# 풀이법 생각

<aside>
💡

</aside>

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_11005_B1;

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
```

### 결과

```java
맞았습니다!
```

### 해결 방법 & 참고자료

너무 문제를 어렵게 풀었다. 왜? 그냥 바로 코드부터 작성하니까 크게 혼난 느낌이다. 이제 브론즈 문제여도 수도코드라도 간단하게 작성해서 풀이하는 것이 훨씬 시간이 적게 걸릴 것으로 보인다.

맞긴 했지만, 위 풀이를 쓰는데 1시간이 걸린 걸 생각해보면 **절대 바람직한 풀이가 아니다.**

그냥 너무 어렵게 생각한 감이 있고, 문제를 풀기 위한 키포인트를 잡지 못한 감이 있다.

# 정답 코드

이렇게 푸는 게 맞다. 내 방법대로 푸는 건 완전…. 시간낭비적인 방법이고 너무 어렵게 생각한 감이 있다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/168ff8f0-7f27-469e-8639-a1e80a94fde7/Untitled.png)

```java
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        String ans = "";
        while (N > 0) {
            int digit = N % B;
            if (digit < 10) ans += digit;
            else ans += (char)('A' + digit - 10);
            N /= B;
        }

        System.out.println(new StringBuilder(ans).reverse());
    }
}
```

간단한 문제를 이렇게 간단하게 풀면 되는데, 난 뭔가 자꾸 어렵게 풀려고하는?? 습관이 있다. 갖다버리기위해서 반드시 먼저 풀이법을 손으로 간단하게 작성하고 코드로 옮기는 것이 좋을 것이다.