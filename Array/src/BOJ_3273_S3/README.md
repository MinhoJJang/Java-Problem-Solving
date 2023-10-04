# 두 수의 합

[문제 링크](https://www.acmicpc.net/problem/3273)

## 문제

<aside>
💡 n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다. ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다. 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

</aside>

## 입력

<aside>
💡 첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)

</aside>

## 출력

<aside>
💡 문제의 조건을 만족하는 쌍의 개수를 출력한다.

</aside>

### 예제 입력

```
9
5 12 7 10 9 1 2 3 11
13
```

### 예제 출력

```
3
```

# 풀이법 생각

<aside>
💡 배열 정렬 후 그냥 앞 뒤 한번씩 더해서 x 되는지 안되는지 체크하면 끝

</aside>

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_3273_S3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n; // 수열의 크기
        n = sc.nextInt();

        int[] arr = new int[n]; // 수열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x; // 만들어야 하는 숫자
        x = sc.nextInt();

        // 1. arr 배열 정렬
        Arrays.sort(arr);

        // 2. arr 배열에서 처음과 끝 idx를 지정
        int first_idx = 0;
        int end_idx = n-1;
        int answer = 0;

        // 3. 처음 idx를 1씩 증가시키면서 값 저장
        while(first_idx < end_idx){

            // arr[end_idx}와 arr[first_idx]를 더한다
            // 만약 그 값이 x 보다 크다면 end_idx를 1 감소시키고 continue;
            // 만약 그 값이 x 보다 작다면 first_idx를 1 증가시키고 continue;
            // 같으면 answer++ 해주고 first_idx, end_idx를 각각 증가/감소시킨다.
            int checkSum = arr[first_idx] + arr[end_idx];
            if (checkSum > x) {
                end_idx--;
            }
            else if(checkSum < x){
                first_idx++;
            }
            else{
                answer++;
                first_idx++;
                end_idx--;
            }
        }

        System.out.println(answer);
    }
}
// 맞았습니다!
```

### 결과

```java
맞음
```

### 해결 방법 & 참고자료

# 정답 코드

```java
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        int X = sc.nextInt();

        int[] cnt = new int[1000001];
        for (int i = 0; i < N; i++)
            cnt[a[i]]++;

        long ans = 0;
        for (int i = 1; i <= (X - 1) / 2; i++)
            if (X - i <= 1000000)
                ans += (long)cnt[i] * cnt[X - i];
        System.out.println(ans);
    }
}
```