# 일곱 난쟁이

[문제 링크](https://www.acmicpc.net/problem/2309)

## 문제

<aside>
💡 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

</aside>

## 입력

<aside>
💡 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

</aside>

## 출력

<aside>
💡 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.

</aside>

### 예제 입력

```
20
7
23
19
10
15
25
8
13
```

### 예제 출력

```
7
8
10
13
19
20
23
```

# 풀이법 생각

<aside>
💡 전체 sum - 100 한 값이 두 난쟁이들 키의 합이니까 그걸 찾으면 된다

</aside>

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_2309_B1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int num = 9; // 난쟁이 수
    static final int max = 100; // 난쟁이 키 합

    static void printAnswer(int i, int j, int[] arr){
        for (int k = 0; k < num; k++) {
            if(k != i && k != j){
                System.out.println(arr[k]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] height = new int[num];
        int sum = 0;

        for (int i = 0; i < num; i++) {
            height[i] = sc.nextInt();
            sum+=height[i];
        }

        Arrays.sort(height);

        int checkSum = sum - 100; // 찾아야할 키 합(두 명분의 키를 빼면 된다)
        for (int i = 0; i < num-1; i++) {
            for (int j = i+1; j < num; j++) {
                if(height[i]+height[j] == checkSum){
                    printAnswer(i,j,height);
                    return;
                }
            }
        }
    }
}
```

### 결과

```java
맞았습니다
```

### 해결 방법 & 참고자료

한 5분만에 푼듯

# 정답 코드

```java
import java.util.Arrays;
import java.util.Scanner;

class Main
{
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int cur = arr[i];
                    for (int k = i; k > j; k--)
                        arr[k] = arr[k - 1];
                    arr[j] = cur;
                    break;
                }
            }
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] h = new int[9];
        for (int i = 0; i < 9; i++)
            h[i] = sc.nextInt();

        // Arrays.sort(h);
        sort(h);

        int sum = Arrays.stream(h).sum();
        boolean find = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++)
                if (sum - h[i] - h[j] == 100) {
                    h[i] = h[j] = -1;
                    find = true;
                    break;
                }
            if (find) break;
        }

        for (int i = 0; i < 9; i++)
            if (h[i] > 0)
                System.out.println(h[i]);
    }
}
```