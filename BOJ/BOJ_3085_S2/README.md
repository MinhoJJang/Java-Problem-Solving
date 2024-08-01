# 사탕 게임

[문제 링크](https://www.acmicpc.net/problem/3085)

## 문제

<aside>
💡 상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

</aside>

## 입력

<aside>
💡 첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.

사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

</aside>

## 출력

<aside>
💡 첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.

</aside>

### 예제 입력 1

```
5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
```

### 예제 출력 1

```
4
```

### 예제 입력 2

```
4
PPPP
CYZY
CCPY
PPCC
```

### 예제 출력 2

```
4
```

### 예제 입력 3

```
3
CCP
CCP
PPC
```

### 예제 출력 3

```
3
```

# 풀이법 생각

<aside>
💡 배열 당 위 아래로 한번씩 바꿔서 모든 경우의 수를 체크하면 된다. N이 50개밖에 안되기 때문에, 그냥 모든 경우를 체크해도계산이 1억이 넘지 않는다.

</aside>

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_3085_S2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int GlobalLongestLength = 1;
    static int N;

    static char[] candy_name = {'C', 'P', 'Z', 'Y'};

    static final int CANNOT_CHANGE = 0;
    static final int CAN_CHANGE = 1;

    static int findLongestSequenceCharLength(char[][] arr) {

        // C, P, Z, Y 에 대하여 연속된 값의 최대 숫자 구하기
        for (int i = 0; i < N; i++) {

            // 1. raw 행을 먼저 구함
            findLocalLongestLength(arr[i]);

            // 2. 해당 행의 위 배열 값과 위치 변경
            if (i > 0) {
                for (int j = 0; j < N; j++) {
                        findLocalLongestLength(switchCandy(arr[i], j, arr[i - 1][j]));

                }
            }

            // 3. 해당 행의 아래 배열 값과 위치 변경
            if (i < N-1) {
                for (int j = 0; j < N; j++) {
                        findLocalLongestLength(switchCandy(arr[i], j, arr[i + 1][j]));

                }
            }
        }
        return GlobalLongestLength;
    }

    static void findLocalLongestLength(char[] arr) {
        int LocalLongestLength = 1;
        for (int i = 0; i < candy_name.length; i++) {
            int temp;
            for (int j = 0; j < N; j++) {
                if (arr[j] == candy_name[i]) {
                    temp = 0;
                    while (j < N && arr[j] == candy_name[i]) {
                        j++;
                        temp++;
                    }
                    if (temp > LocalLongestLength) {
                        LocalLongestLength = temp;
                    }
                }
            }
        }

        if (GlobalLongestLength < LocalLongestLength) {
            GlobalLongestLength = LocalLongestLength;
        }
    }

    static char[] switchCandy(char[] base, int idx, char c) {
        char[] dest  = Arrays.copyOf(base, N);
        dest[idx] = c;
        return dest;
    }

    static void transpose(char arr[][], char arr2[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr2[j][i] = arr[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        char[][] candy = new char[N][N];
        char[][] candyT = new char[N][N]; // Transpose 된 candy 배열

        for (int i = 0; i < N; i++) {
            candy[i] = sc.next().toCharArray();
        }

        transpose(candy, candyT);
        findLongestSequenceCharLength(candy);
        findLongestSequenceCharLength(candyT);
        
        System.out.println(GlobalLongestLength);
    }
}
```

### 결과

```java
틀렸습니다.
```

### 해결 방법 & 참고자료

게시판에서 계속 반례를 찾으니 하나 발견했다.

```java
4
CPCP
YZYZ
CCPC
ZYZY

3
```

저기서 CCPC 에서 PC를 바꿔 3을 나오게 해야 하는데, 내 코드는 2를 출력한다. 디버깅을 해보자…

수평변환을 빼먹었다………….!!!

## 2차 풀이

### 코드

```java
package BOJ_3085_S2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int PREVIOUS = -1;
    static final int NEXT = 1;
    static int GlobalLongestLength = 1;
    static int N;
    static char[] candy_name = {'C', 'P', 'Z', 'Y'};

    static int findLongestSequenceCharLength(char[][] arr) {

        // C, P, Z, Y 에 대하여 연속된 값의 최대 숫자 구하기
        for (int i = 0; i < N; i++) {

            // 1. raw 행을 먼저 구함
            findLocalLongestLength(arr[i]);

            // 2. 해당 행의 위 배열 값과 위치 변경
            if (i > 0) {
                for (int j = 0; j < N; j++) {
                    findLocalLongestLength(switchCandyVertically(arr[i], j, arr[i - 1][j]));
                    if (j > 0) {
                        findLocalLongestLength(switchCandyHorizontally(arr[i], j, arr[i][j - 1], PREVIOUS));
                    }
                    if (j < N - 1) {
                        findLocalLongestLength(switchCandyHorizontally(arr[i], j, arr[i][j + 1], NEXT));
                    }
                }
            }

            // 3. 해당 행의 아래 배열 값과 위치 변경
            if (i < N - 1) {
                for (int j = 0; j < N; j++) {
                    findLocalLongestLength(switchCandyVertically(arr[i], j, arr[i + 1][j]));
                    if (j > 0) {
                        findLocalLongestLength(switchCandyHorizontally(arr[i], j, arr[i][j - 1], PREVIOUS));
                    }
                    if (j < N - 1) {
                        findLocalLongestLength(switchCandyHorizontally(arr[i], j, arr[i][j + 1], NEXT));
                    }
                }
            }
        }
        return GlobalLongestLength;
    }

    static void findLocalLongestLength(char[] arr) {
        int LocalLongestLength = 1;
        for (int i = 0; i < candy_name.length; i++) {
            int temp;
            for (int j = 0; j < N; j++) {
                if (arr[j] == candy_name[i]) {
                    temp = 0;
                    while (j < N && arr[j] == candy_name[i]) {
                        j++;
                        temp++;
                    }
                    if (temp > LocalLongestLength) {
                        LocalLongestLength = temp;
                    }
                }
            }
        }

        if (GlobalLongestLength < LocalLongestLength) {
            GlobalLongestLength = LocalLongestLength;
        }
    }

    static char[] switchCandyVertically(char[] base, int idx, char c) {
        char[] dest = Arrays.copyOf(base, N);
        dest[idx] = c;
        return dest;
    }

    static char[] switchCandyHorizontally(char[] base, int idx, char c, int dir) {
        char[] dest = Arrays.copyOf(base, N);
        dest[idx + dir] = dest[idx];
        dest[idx] = c;

        return dest;
    }
    

    static void transpose(char[][] arr, char[][] arr2) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr2[j][i] = arr[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        char[][] candy = new char[N][N];
        char[][] candyT = new char[N][N]; // Transpose 된 candy 배열

        for (int i = 0; i < N; i++) {
            candy[i] = sc.next().toCharArray();
        }

        transpose(candy, candyT);
        findLongestSequenceCharLength(candy);
        findLongestSequenceCharLength(candyT);

        System.out.println(GlobalLongestLength);
    }
}
```

### 결과

```java
맞았습니다!!
```

### 해결 방법 & 참고자료

수평변환을 깜박하고 안넣어서 추가해주었다.

근데 총 풀이에 100분이 걸린건… 오래 걸리긴 했다

# 모범 풀이

## 접근법

### 1. 사탕 교환 방법 최적화

아래와 같이 모든 4방향에 대해 교환하면 이렇게 중복되는 경우가 생기게 되고 쓸데없는 연산이 추가되어 메모리와 시간 모두 낭비된다. 내가 한 방법이 이렇게 한것이라..

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/19d511ac-f565-4944-a19e-0fc05e7859bb/Untitled.png)

좌표 하나에 대하여, 오른쪽, 아래만 교환하는 방식으로 하는 것이 내가 사용한 방법보다 훨씬 간단하다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/e72dd3d6-c707-4bde-968e-bfd3ef477854/Untitled.png)

### 2. 연속 행/열 찾기

이 부분은 내가 사용한 방법과 유사하다. 다만 두 가지 방법이 있다. 나는 (2) 번을 사용했다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/94746961-2799-4f74-8f32-b913f296fc4e/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/7f20f76a-6e81-4e5e-b3b5-359dc12b8570/Untitled.png)

## 코드

```java
import java.util.Scanner;

class Main
{
    public static int calcScore(char[][] map) {
        int N = map.length;
        int maxScore = 0;
        // 가장 긴 연속 column 길이 찾기
        for (int r = 0; r < N; r++) {
            int scr = 1;
            for (int c = 1; c < N; c++) {
                if (map[r][c] == map[r][c - 1]) scr++;
                else {
                    maxScore = Math.max(maxScore, scr);
                    scr = 1;
                }
            }
            maxScore = Math.max(maxScore, scr);
        }
        // 가장 긴 연속 row 길이 찾기
        for (int c = 0; c < N; c++) {
            int scr = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r - 1][c]) scr++;
                else {
                    maxScore = Math.max(maxScore, scr);
                    scr = 1;
                }
            }
            maxScore = Math.max(maxScore, scr);
        }
        return maxScore;
    }

    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        int ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++){
                // swap right
                if (j + 1 < N) {
                    swapCandy(map, i, j, i, j + 1);
                    ans = Math.max(ans, calcScore(map));
                    swapCandy(map, i, j, i, j + 1);
                }
                // swap below
                if (i + 1 < N) {
                    swapCandy(map, i, j, i + 1, j);
                    ans = Math.max(ans, calcScore(map));
                    swapCandy(map, i, j, i + 1, j);
                }
            }
        System.out.println(ans);
    }
}
```

## 결과 비교

- 내 풀이

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/fb483a83-3bf7-4732-becd-e4ff1e01c4ed/Untitled.png)

- 모범 풀이

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/dcd0bdc7-7b22-48f0-95d9-9c47dabf1c41/Untitled.png)

…?? 시간은왜?? 자바는 참 신기하다