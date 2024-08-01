# 요격 시스템

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181188)

## 문제

<aside>
💡 A 나라가 B 나라를 침공하였습니다. B 나라의 대부분의 전략 자원은 아이기스 군사 기지에 집중되어 있기 때문에 A 나라는 B 나라의 아이기스 군사 기지에 융단폭격을 가했습니다.

A 나라의 공격에 대항하여 아이기스 군사 기지에서는 무수히 쏟아지는 폭격 미사일들을 요격하려고 합니다. 이곳에는 백발백중을 자랑하는 요격 시스템이 있지만 운용 비용이 상당하기 때문에 미사일을 최소로 사용해서 모든 폭격 미사일을 요격하려 합니다.

A 나라와 B 나라가 싸우고 있는 이 세계는 2 차원 공간으로 이루어져 있습니다. A 나라가 발사한 폭격 미사일은 x 축에 평행한 직선 형태의 모양이며 개구간을 나타내는 정수 쌍 (s, e) 형태로 표현됩니다. B 나라는 특정 x 좌표에서 y 축에 수평이 되도록 미사일을 발사하며, 발사된 미사일은 해당 x 좌표에 걸쳐있는 모든 폭격 미사일을 관통하여 한 번에 요격할 수 있습니다. 단, 개구간 (s, e)로 표현되는 폭격 미사일은 s와 e에서 발사하는 요격 미사일로는 요격할 수 없습니다. 요격 미사일은 실수인 x 좌표에서도 발사할 수 있습니다.

각 폭격 미사일의 x 좌표 범위 목록

```
targets
```

이 매개변수로 주어질 때, 모든 폭격 미사일을 요격하기 위해 필요한 요격 미사일 수의 최솟값을 return 하도록 solution 함수를 완성해 주세요.

</aside>

## 제한사항

<aside>
💡 1 ≤ `targets`의 길이 ≤ 500,000

targets의 각 행은 [s,e] 형태입니다.

이는 한 폭격 미사일의 x 좌표 범위를 나타내며, 개구간 (s, e)에서 요격해야 합니다.

0 ≤ s < e ≤ 100,000,000

</aside>

### 예제 입력

```
[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
```

### 예제 출력

```
3
```

![그림.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/13c4309b-d05a-471f-9715-ca31511a758d/d0032fb3-e512-40a9-bc96-fa22c81ae3ed/%EA%B7%B8%EB%A6%BC.png)

# 풀이법 생각

<aside>
💡 target을 끝나는 시간이 빠른 순서대로 나열하고,
끝나는 시간이 같다면 시작 시간이 빠른 값을 체크
그래서 그렇게 체크한 target 개수가 결국 정답이다.

</aside>

# 내 풀이

## 1차 풀이

### 코드

```java
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));
        int len = targets.length;
        int end_time = targets[0][1];
        answer += 1;
        for (int i = 1; i < len; i++) {
            if(end_time <= targets[i][0]){
                end_time = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}
```

### 결과

```java
정확성  테스트
테스트 1 〉	통과 (2.43ms, 79.1MB)
테스트 2 〉	통과 (2.69ms, 73.2MB)
테스트 3 〉	통과 (2.70ms, 73.7MB)
테스트 4 〉	통과 (3.42ms, 75.7MB)
테스트 5 〉	통과 (12.10ms, 85.4MB)
테스트 6 〉	통과 (117.33ms, 112MB)
테스트 7 〉	통과 (360.27ms, 181MB)
테스트 8 〉	통과 (365.77ms, 191MB)
테스트 9 〉	통과 (561.13ms, 177MB)
테스트 10 〉	통과 (21.15ms, 167MB)
테스트 11 〉	통과 (1.96ms, 78.4MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```
