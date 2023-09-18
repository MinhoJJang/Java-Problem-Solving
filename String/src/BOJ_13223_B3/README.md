# 소금폭탄

[문제 링크](https://www.acmicpc.net/problem/13223)

## 문제

<aside>
💡 철수는 화학 시험을 망치고, 애꿎은 화학 선생님에게 복수를하기로 한다.

철수는 집에서 만든 자동 로봇팔을 선생님의 책상에 숨겨, 선생님이 수업을 시작하려 들어온 순간 숨겨놓은 로봇팔을 이용해 선생님을 혼내주려고한다. 철수는 선생님이 늘 애용하는 물컵에 시간이 되면 로봇팔이 소금을 잔뜩 집어넣도록 프로그램을 짜려고한다.

철수는 현재시각과 선생님이 언제 컵을 사용할지 시간을 알고있지만, 수 계산에 정말 약해서 로봇팔에 입력해야할 시간 계산을 못한다. 철수가 로봇팔에 알맞은 시간을 입력할수 있도록 도와주자.

</aside>

## 입력

<aside>
💡 첫째 줄에는 현재 시각이 hh:mm:ss로 주어진다. 시간의 경우 0≤h≤23 이며, 분과 초는 각각 0≤m≤59, 0≤s≤59 이다.

두 번째 줄에는 소금 투하의 시간이 hh:mm:ss로 주어진다.

</aside>

## 출력

<aside>
💡 로봇팔이 소금을 투하할때까지 필요한 시간을 hh:mm:ss로 출력한다. 이 시간은 1초보다 크거나 같고, 24시간보다 작거나 같다.

</aside>

### 예제 입력 1

```
20:00:00
04:00:00
```

### 예제 출력 1

```
08:00:00
```

### 예제 입력 2

```
12:34:56
14:36:22
```

### 예제 출력 2

```
12:34:56
14:36:22
```

# 풀이법 생각

<aside>
💡 hh:mm:ss 2개가 주어질텐데 일단 각각 : 로 구분되어있는 걸 없애주자

</aside>

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_13223_B3;

import java.util.Scanner;

public class Main {

    static final int h = 0;
    static final int m = 1;
    static final int s = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();

        String[] first_time = first.split(":");
        String[] second_time = second.split(":");
        int[] need_time = {0,0,0};
        String[] need_time_str = {"00", "00", "00"};

        for(int i=h; i<=s; i++){
            need_time[i] = Integer.parseInt(second_time[i]) - Integer.parseInt(first_time[i]);

        }

        for(int i=s; i>=h; i--) {
            if(need_time[i] < 0 && i>=m){
                need_time[i]+=60;
                need_time[i-1]--;
            }

            if(need_time[i] < 0 && i==h){
                need_time[i] += 24;
            }

            if(need_time[i] < 10) {
                need_time_str[i] = "0" + String.valueOf(need_time[i]);
            }
            else{
                need_time_str[i] = String.valueOf(need_time[i]);
            }
        }

        System.out.println(need_time_str[h] + ":" + need_time_str[m] + ":" + need_time_str[s]);
    }
}
```

### 결과

```java
틀렸습니다
```

### 해결 방법 & 참고자료

[글 읽기 - 도와주세요ㅠ](https://www.acmicpc.net/board/view/120419)

### 반례 입력

```
00:00:00
00:00:00
```

### 반례 출력

```
24:00:00
```

하지만 내 코드를 실행시키면 00:00:00 이 나온다. 24시간인 경우를 생각하지 못했다

## 2차 풀이

### 코드

```java
package BOJ_13223_B3;

import java.util.Scanner;

public class Main {

    static final int h = 0;
    static final int m = 1;
    static final int s = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();

        String[] first_time = first.split(":");
        String[] second_time = second.split(":");
        int[] need_time = {0,0,0};
        String[] need_time_str = {"00", "00", "00"};

        for(int i=h; i<=s; i++){
            need_time[i] = Integer.parseInt(second_time[i]) - Integer.parseInt(first_time[i]);

        }

        for(int i=s; i>=h; i--) {
            if(need_time[i] < 0 && i>=m){
                need_time[i]+=60;
                need_time[i-1]--;
            }

            if(need_time[i] < 0 && i==h){
                need_time[i] += 24;
            }

            if(need_time[h] == 0 && need_time[m] == 0 && need_time[s] == 0){
                need_time[h] += 24;
            }

            if(need_time[i] < 10) {
                need_time_str[i] = "0" + String.valueOf(need_time[i]);
            }
            else{
                need_time_str[i] = String.valueOf(need_time[i]);
            }
        }

        System.out.println(need_time_str[h] + ":" + need_time_str[m] + ":" + need_time_str[s]);
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
package BOJ_13223_B3;
import java.util.Scanner;
public class Answer {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] current = sc.next().split(":");
        String[] target = sc.next().split(":");

        int currentHour = Integer.parseInt(current[0]);
        int currentMinute = Integer.parseInt(current[1]);
        int currentSecond = Integer.parseInt(current[2]);

        int targetHour = Integer.parseInt(target[0]);
        int targetMinute = Integer.parseInt(target[1]);
        int targetSecond = Integer.parseInt(target[2]);

        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;
        int targetSecondAmount = targetHour * 3600 + targetMinute * 60 + targetSecond;

        int NeedSecondAmount = targetSecondAmount - currentSecondAmount;
        if (NeedSecondAmount <= 0) NeedSecondAmount += 24 * 3600;

        int needHour = NeedSecondAmount / 3600;
        int needMinute = (NeedSecondAmount % 3600) / 60;
        int needSecond = NeedSecondAmount % 60;

        System.out.println(String.format("%02d:%02d:%02d", needHour, needMinute, needSecond));
    }
    }
}
```