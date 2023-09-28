# 개미

[문제 링크](https://www.acmicpc.net/problem/10158)

## 문제

<aside>
💡 가로 길이가 w이고 세로 길이가 h인 2차원 격자 공간이 있다. 이 격자는 아래 그림처럼 왼쪽 아래가 (0,0)이고 오른쪽 위가 (w,h)이다. 이 공간 안의 좌표 (p,q)에 개미 한 마리가 놓여있다. 개미는 오른쪽 위 45도 방향으로 일정한 속력으로 움직이기 시작한다. 처음에 (p,q)에서 출발한 개미는 1시간 후에는 (p+1,q+1)로 옮겨간다. 단, 이 속력으로 움직이다가 경계면에 부딪치면 같은 속력으로 반사되어 움직인다.

https://upload.acmicpc.net/95e84480-219b-4628-a65d-7b08bc3758e5/-/preview/

위 그림은 6×4 격자에서 처음에 (4,1)에서 출발한 개미가 움직인 길을 보여주고 있다. 처음에 (4,1)에 있는 개미는 2시간 후에 (6,3)에 있으며 8시간 후에 (0,1)에 있다. 만일 그 개미가 처음에 (5,3)에 있었다면 매 시간마다 (6,4), (5,3), (4,2), (3,1)로 움직인다.

여러분은 크기 w×h인 격자 공간에서 처음에 (p,q)에서 출발하는 개미의 t시간 후의 위치 (x,y)를 계산하여 출력해야 한다. 개미는 절대 지치지 않고 같은 속력으로 이동한다고 가정한다.

문제에서 w와 h는 자연수이며 범위는 2 ≤ w,h ≤ 40,000이다. 그리고 개미의 초기 위치 p와 q도 자연수이며 범위는 각각 0 < p < w과 0 < q < h이다. 그리고 계산할 시간 t의 범위는 1 ≤ t ≤ 200,000,000이다.

</aside>

## 입력

<aside>
💡 첫줄에는 w와 h가 공백을 사이에 두고 주어진다. 그 다음 줄에는 초기 위치의 좌표값 p와 q가 공백을 사이에 두고 주어진다. 3번째 줄에는 개미가 움직일 시간 t가 주어진다.

</aside>

## 출력

<aside>
💡 출력은 t 시간 후에 개미의 위치 좌표 (x,y)의 값 x와 y를 공백을 사이에 두고 출력한다.

</aside>

### 예제 입력

```
6 4
5 3
4
```

### 예제 출력

```
3 1
```

### 예제 입력

```
6 4
4 1
8
```

### 예제 출력

```
0 1
```

# 풀이법 생각

<aside>
💡 최종 좌표를 찍고 직사각형 범위를 벗어나면 접어서 좌표를 이동시키는 방식으로 해봤음

</aside>

—> 매우 매우 어려운 접근법

그냥 x 따로 y 따로 계산하면 되는걸….

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_10158_S4;

import java.util.Scanner;

public class Main {

    final static int TOP_RIGHT = 0;
    final static int BOT_RIGHT = 1;
    final static int BOT_LEFT = 2;
    final static int TOP_LEFT = 3;

    final static int x = 0;
    final static int y = 1;
    final static int same = 2;

    static boolean insideBox(int[] end, int[][] box){
        if(end[x] >= 0 && end[x] <= box[TOP_RIGHT][x] && end[y] >= 0 && end[y] <= box[TOP_RIGHT][y]){
            return true;
        }
        return false;
    }

    static int compare(int a, int b){
        if(Math.abs(a)<Math.abs(b)){
            return x;
        }
        else if(Math.abs(a)>Math.abs(b)){
            return y;
        }
        return same;
    }

    static int[] fn(int[] start, int[] end, int[][] box, int dir){

        if(insideBox(end, box)){
            // 최종 좌표가 box 내에 존재하므로 해당 좌표가 최종 위치임
            return end;
        }

        int closeOne;
        int distance;
        // 경계점은 TOP_RIGHT일 경우 오른쪽 위 꼭짓점 좌표이다.
        // 1. 경계점까지 x,y 중 뭐가 더 가까운지 찾는다. 0이면 x, 1이면 y, 2이면 동시에 경계점에 도착했다는 뜻
        closeOne = compare(start[x] - box[dir][x], start[y] - box[dir][y]);

        if(dir == TOP_RIGHT){
            if(closeOne == x){
                distance = Math.abs(start[x] - box[dir][x]);
                dir = TOP_LEFT;
                end[x] -= 2*(end[x] - (start[x] + distance));
            }
            else if(closeOne == y){
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_RIGHT;
                end[y] -= 2*(end[y] - (start[y] + distance));
            }
            else{
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_LEFT;
                end[y] -= 2*(end[y] - (start[y] + distance));
                end[x] -= 2*(end[x] - (start[x] + distance));
            }
            start[x] += distance;
            start[y] += distance;
        }
        else if(dir == BOT_RIGHT){
            if(closeOne == x){
                distance = Math.abs(start[x] - box[dir][x]);
                dir = TOP_RIGHT;
                end[x] -= 2*(end[x] - (start[x] + distance));
            }
            else if(closeOne == y){
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_LEFT;

                end[y] -= 2*(end[y] - (start[y] - distance));
            }
            else{
                distance = Math.abs(start[y] - box[dir][y]);
                dir = TOP_LEFT;
                end[y] -= 2*(end[y] - (start[y] - distance));
                end[x] -= 2*(end[x] - (start[x] + distance));
            }
            start[x] += distance;
            start[y] -= distance;
        }
        else if(dir == BOT_LEFT){
            if(closeOne == x){
                distance = Math.abs(start[x] - box[dir][x]);
                dir = BOT_RIGHT;
                end[x] -= 2*(end[x] - (start[x] - distance));
            }
            else if(closeOne == y){
                distance = Math.abs(start[y] - box[dir][y]);
                dir = TOP_LEFT;
                end[y] -= 2*(end[y] - (start[y] - distance));
            }
            else{
                distance = Math.abs(start[y] - box[dir][y]);
                dir = TOP_RIGHT;
                end[y] -= 2*(end[y] - (start[y] - distance));
                end[x] -= 2*(end[x] - (start[x] - distance));
            }
            start[x] -= distance;
            start[y] -= distance;
        }
        else if(dir == TOP_LEFT){
            if(closeOne == x){
                distance = Math.abs(start[x] - box[dir][x]);
                dir = TOP_RIGHT;
                end[x] -= 2*(end[x] - (start[x] - distance));
            }
            else if(closeOne == y){
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_LEFT;

                end[y] -= 2*(end[y] - (start[y] + distance));
            }
            else{
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_RIGHT;
                end[y] -= 2*(end[y] - (start[y] + distance));
                end[x] -= 2*(end[x] - (start[x] - distance));
            }
            start[x] -= distance;
            start[y] += distance;
        }

        return fn(start, end, box, dir);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w, h, p, q, t;
        w = sc.nextInt();
        h = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();
        t = sc.nextInt();

        int[][] box = {
                {w, h},
                {w, 0},
                {0, 0},
                {0, h}
        };

        int[] start = {p, q};
        int[] end = {p+t, q+t};
        int dir = TOP_RIGHT;
        int[] answer = new int[2];

        answer = fn(start, end, box, dir);
        System.out.printf("%d %d", answer[x], answer[y]);

    }
}
```

### 결과

```java
메모리 초과
```

### 해결 방법 & 참고자료

반복된 재귀호출로 메모리를 많이 잡아먹는것이 원인인 듯 하다. 사실 코드가 너무 길다.

## 2차 풀이

### 코드

```java
package BOJ_10158_S4;

import java.util.Scanner;

public class GPT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();

        int final_x = (p + t) % w;
        int final_y = (q + t) % h;

        if (((p + t) / w) % 2 == 1) {
            final_x = w - final_x;
        }
        if (((q + t) / h) % 2 == 1) {
            final_y = h - final_y;
        }

        System.out.printf("%d %d", final_x, final_y);
    }
}
```

### 결과

```java
시간초과
```

### 해결 방법 & 참고자료

GPT에게 1차 풀이 코드를 주고 최적화 해달라고 했더니 아예 답을 줬다..  천재적이다! 왜 이생각을 못했을까..

일단 개미가 2차원에 있다는 생각을 버려야한다. 즉 x따로 y따로 보자는 뜻이다. 어차피 x랑 y는 서로 영향을 주지 않으니까. 그러니 x축 방향으로 간 만큼을 계산하고 몇 번 반사되는지를 찾으면 된다!! 이 쉬운걸 저따구로 어렵게 풀고 있었다!

근데 웃긴 점은 이게 시간초과라는 사실…

즉 t가 2억이니 O(n)으로 계산 시 2초가 걸리는데, 문제의 제한시간은 고작 0.15초 이다. 따지자면 O(root(n))로 푸는 알고리즘을 생각해 내야 한다.

근데 위 풀이는 아무리봐도 O(n)도 아니고…. 혹시 Scanner에서 시간이 걸리는건가??

## 3차 풀이

그냥 Java 15 문제였다. 제출언어를 Java8로 변경하거나 BufferedWriter을 사용하면 시간을 조금이나마 더 줄일 수 있다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/d425eee1-d050-4cf1-a3b1-d9b17269490e/Untitled.png)

# 정답 코드