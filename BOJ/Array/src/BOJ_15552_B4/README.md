# 빠른 A+B

[문제 링크](https://www.acmicpc.net/problem/15552)

## 문제

<aside>
💡 본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.

C++을 사용하고 있고 `cin`/`cout`을 사용하고자 한다면, `cin.tie(NULL)`과 `sync_with_stdio(false)`를 둘 다 적용해 주고, `endl` 대신 개행문자(`\n`)를 쓰자. 단, 이렇게 하면 더 이상 `scanf`/`printf`/`puts`/`getchar`/`putchar` 등 C의 입출력 방식을 사용하면 안 된다.

Java를 사용하고 있다면, `Scanner`와 `System.out.println` 대신 `BufferedReader`와 `BufferedWriter`를 사용할 수 있다. `BufferedWriter.flush`는 맨 마지막에 한 번만 하면 된다.

Python을 사용하고 있다면, `input` 대신 `sys.stdin.readline`을 사용할 수 있다. 단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우 `.rstrip()`을 추가로 해 주는 것이 좋다.

또한 입력과 출력 스트림은 별개이므로, 테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다. 테스트케이스를 하나 받은 뒤 하나 출력해도 된다.

자세한 설명 및 다른 언어의 경우는 [이 글](http://www.acmicpc.net/board/view/22716)에 설명되어 있다.

[이 블로그 글](http://www.acmicpc.net/blog/view/55)에서 BOJ의 기타 여러 가지 팁을 볼 수 있다.

</aside>

## 입력

<aside>
💡 첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.

</aside>

## 출력

<aside>
💡 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.

</aside>

### 예제 입력

```
5
1 1
12 34
5 500
40 60
1000 1000
```

### 예제 출력

```
2
46
505
100
2000
```

# 풀이법 생각

<aside>
💡 단순히 `Scanner`로 받으면 안되고`BufferedReader`와 `BufferedWriter` 을 사용해야 한다. 해당 방법으로 풀어본적이 없어서, 블로그를 참고하였다.

</aside>

[[JAVA] BufferedReader 와 Bufferedwriter 사용법](https://m.blog.naver.com/ka28/221850826909)

## `BufferedReader` & `BufferedWriter`

`BufferedReader`은 `Scanner`와 유사하고 `BufferedWriter`은 `sout`와 비슷하다.

그래서 버퍼를 쓰는 이유가 뭐냐? 라고 한다면, 속도 측면에서 매우 빠르다. 다만 속도가 빠른 대신 데이터의 가공이 추가적으로 필요하다.

### Import

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
```

### `BufferedReader` 사용법

```java
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
String s = bf.readLine(); //String
int i = Integer.parseInt(bf.readLine()); //I
```

유의사항

1. `readLine()`은 타입이 String이므로, `int` 타입으로 받고 싶으면 형변환이 필수적이다.
2. 예외처리가 필수적이다. 주로 `main` 함수에서 `import java.io.IOException;` ** 해주고 `throws IOException`를 사용해 처리한다.
3. Read한 데이터는 Line단위로만 나눠진다. 즉 공백으로 구분해서 들어오는 문자들에 대해서 추가적인 처리가 필요하다.
    1. `StringTokenizer`에 `nextToken()` 함수를 사용해 `readLine()`을 통해 입력받은 값을 공백 단위로 구분하여 호출할 수 있다.

        ```java
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String s = bf.readLine(); //String
        
        StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
        int a = Integer.parseInt(st.nextToken()); //첫번째 호출
        int b = Integer.parseInt(st.nextToken()); //두번째 호출
        ```

    2. `String.split()`함수를 활용하여 배열에 공백단위로 끊어서 데이터를 넣고 사용할 수 있다.

        ```java
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String s = bf.readLine(); //String
        
        String array[] = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
        ```



### `BufferedWriter` 사용법

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
String s = "abcdefg";   //출력할 문자열
bw.write(s+"\n");   //버퍼에 있는 값 전부 출력
bw.flush();   //남아있는 데이터를 모두 출력시킴
bw.close();   //스트림을 닫음
```

`BufferedWriter` 의 경우 버퍼를 잡아 놓았기 때문에 반드시 `flush() / close()` 를 반드시 호출해 주어 뒤처리를 해주어야 한다.

그리고 `bw.write`에는 `System.out.println();`과 같이 자동개행기능이 없기때문에 개행을 해주어야할 경우에는 `\n`를 통해 따로 처리해주어야 한다.

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_15552_B4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        while(T > 0){
            String s = bf.readLine();
            String[] arr = s.split(" ");
            int answer = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
            bw.write(answer+"\n");
            T--;
        }
        bw.flush();
        bw.close();
    }
}
```

### 결과

```java
맞았습니다!!	289608KB	984ms
```

자바가 다른 언어와 비교했을 때 진짜 압도적으로 느리긴 하다..