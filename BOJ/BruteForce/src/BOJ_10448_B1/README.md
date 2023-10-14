# 유레카 이론

[문제 링크](https://www.acmicpc.net/problem/10448)

## 문제

<aside>
💡 삼각수 Tn(n ≥ 1)는 [그림]에서와 같이 기하학적으로 일정한 모양의 규칙을 갖는 점들의 모음으로 표현될 수 있다.

!https://www.acmicpc.net/upload/images2/eureka.png

[그림]

자연수 n에 대해 n ≥ 1의 삼각수 Tn는 명백한 공식이 있다.

Tn = 1 + 2 + 3 + ... + n = n(n+1)/2

1796년, 가우스는 모든 자연수가 최대 3개의 삼각수의 합으로 표현될 수 있다고 증명하였다. 예를 들어,

- 4 = T1+ T2
- 5 = T1 + T1 + T2
- 6 = T2 + T2 or 6 = T3
- 10 = T1 + T2 + T3 or 10 = T4

이 결과는 증명을 기념하기 위해 그의 다이어리에 “Eureka! num = Δ + Δ + Δ” 라고 적은것에서 유레카 이론으로 알려졌다. 꿍은 몇몇 자연수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 궁금해졌다. 위의 예시에서, 5와 10은 정확히 3개의 삼각수의 합으로 표현될 수 있지만 4와 6은 그렇지 않다.

자연수가 주어졌을 때, 그 정수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 없는지를 판단해주는 프로그램을 만들어라. 단, 3개의 삼각수가 모두 달라야 할 필요는 없다.

</aside>

## 입력

<aside>
💡 프로그램은 표준입력을 사용한다. 테스트케이스의 개수는 입력의 첫 번째 줄에 주어진다. 각 테스트케이스는 한 줄에 자연수 K (3 ≤ K ≤ 1,000)가 하나씩 포함되어있는 T개의 라인으로 구성되어있다.

</aside>

## 출력

<aside>
💡 프로그램은 표준출력을 사용한다. 각 테스트케이스에대해 정확히 한 라인을 출력한다. 만약 K가 정확히 3개의 삼각수의 합으로 표현될수 있다면 1을, 그렇지 않다면 0을 출력한다.

</aside>

### 예제 입력

```
3
10
20
1000
```

### 예제 출력

```
1
0
1
```

# 풀이법 생각

<aside>
💡 삼각수를 모두 구하고, 브루트 포스 방법으로 모두 한번씩 더해서 삼각수인지 아닌지 체크한다.

</aside>

이 문제를 풀면서 느낀건 뭔가 최적화가 안되고 쓸데없는 연산이 눈에 보이지만 그럼에도 불구하고 코드가 짧고 간단하기 때문에 T가 작은 경우에 사용가능하다.

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_10448_B1;

import java.util.Scanner;

public class Main2 {
    static int n = 45;
    static int T;
    static int idx = 0;
    static int TRIANGLE_NUMBER = 1;
    static int[] tri = new int[n];

    static void fn(int num, int[] answer){
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if(tri[i] + tri[j] + tri[k] == num) {
                        answer[idx] = TRIANGLE_NUMBER;
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int k = n;
        int[] answer = new int[T];
        while(k > 0){
            tri[k-1] = k*(k+1)/2;
            k--;
        }

        for (int i = 0; i < T; i++) {
            fn(sc.nextInt(), answer);
            idx++;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
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
    static boolean[] isEurekaNumber = new boolean[1001];

    public static void preprocess() {
        int[] triangleNumbers = new int[50];
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber > 1000) break;
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }

        for (int i = 0; i < triangleNumberCount; i++)
            for (int j = i; j < triangleNumberCount; j++)
                for (int k = j; k < triangleNumberCount; k++) {
                    int eurekaNumber = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
                    if (eurekaNumber > 1000) break;
                    isEurekaNumber[eurekaNumber] = true;
                }
    }

    public static void main (String[] args) {
        preprocess();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            System.out.println(isEurekaNumber[K] ? "1" : "0");
        }
    }
}
```