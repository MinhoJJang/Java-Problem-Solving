# [문제 이름]

[문제 링크](https://www.acmicpc.net/problem/1236)

## 문제

<aside>
💡

영식이는 직사각형 모양의 성을 가지고 있다. 성의 1층은 몇 명의 경비원에 의해서 보호되고 있다. 영식이는 모든 행과 모든 열에 한 명 이상의 경비원이 있으면 좋겠다고 생각했다.

성의 크기와 경비원이 어디있는지 주어졌을 때, 몇 명의 경비원을 최소로 추가해야 영식이를 만족시키는지 구하는 프로그램을 작성하시오.

</aside>

## 입력

<aside>
💡 첫째 줄에 성의 세로 크기 N과 가로 크기 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 성의 상태가 주어진다. 성의 상태는 .은 빈칸, X는 경비원이 있는 칸이다.

</aside>

## 출력

<aside>
💡 첫째 줄에 추가해야 하는 경비원의 최솟값을 출력한다.

</aside>

### 예제 입력

```
4 4
....
....
....
....
```

### 예제 출력

```
4
```

### 예제 입력

```
3 5
XX...
.XX..
...XX
```

### 예제 출력

```
0
```

### 예제 입력

```
5 8
....XXXX
........
XX.X.XX.
........
........
```

### 예제 출력

```
3
```

# 풀이법 생각

<aside>
💡 그냥 가로세로 경비원이 없는 줄 개수 센 다음 더 큰 쪽을 반환하면 끝
왜 why? 가로세로 개수가 같다고 생각하면, 교점에다가 경비원 배치하는게 최소수일 테니까.

</aside>

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_1236_B1;

import java.util.Scanner;

public class Main {

    static int checkX(char[][] status) {
        int w = status[0].length; // 가로길이
        int h = status.length; // 세로길이
        int needH = 0; // 가로가 텅 빌 경우 +1
        int needW = 0; // 세로가 텅 빌 경우 +1

        // 가로가 비었는지 체크
        for (int i = 0; i < h; i++) {
            int j;

            for (j = 0; j < w; j++) {
                if (status[i][j] == 'X') {
                    break;
                }
            }

            if (j == w) {
                needH++;
            }
        }

        for (int i = 0; i < w; i++) {
            int j;

            for (j = 0; j < h; j++) {
                if (status[j][i] == 'X') {
                    break;
                }
            }

            if (j == h) {
                needW++;
            }
        }

        if (needW > needH) {
            return needW;
        }
        return needH;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        char[][] status = new char[N][M];
        for (int i = 0; i < N; i++) {
            status[i] = sc.next().toCharArray();
        }
        System.out.println(checkX(status));
    }
}
```

### 결과

```java
맞았습니다!
```

### 해결 방법 & 참고자료

거의 15분? 정도에 푼 것같다. 너무 최적화가 안되어있긴한데.. 브론즈문제답게 그냥 쉬웠다.

# 정답 코드

```java
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        boolean[] rowExist = new boolean[N];
        boolean[] colExist = new boolean[M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 'X') {
                    rowExist[i] = true;
                    colExist[j] = true;
                }

        int rowNeedCount = N;
        int colNeedCount = M;
        for (int i = 0; i < N; i++)
            if (rowExist[i]) rowNeedCount--;
        for (int i = 0; i < M; i++)
            if (colExist[i]) colNeedCount--;

        System.out.println(Math.max(rowNeedCount, colNeedCount));
    }
}
```