# 문서 검색

[문제 링크](https://www.acmicpc.net/problem/1543)

## 문제

<aside>
💡 세준이는 영어로만 이루어진 어떤 문서를 검색하는 함수를 만들려고 한다. 이 함수는 어떤 단어가 총 몇 번 등장하는지 세려고 한다. 그러나, 세준이의 함수는 중복되어 세는 것은 빼고 세야 한다. 예를 들어, 문서가 abababa이고, 그리고 찾으려는 단어가 ababa라면, 세준이의 이 함수는 이 단어를 0번부터 찾을 수 있고, 2번부터도 찾을 수 있다. 그러나 동시에 셀 수는 없다.

세준이는 문서와 검색하려는 단어가 주어졌을 때, 그 단어가 최대 몇 번 중복되지 않게 등장하는지 구하는 프로그램을 작성하시오.

</aside>

## 입력

<aside>
💡 첫째 줄에 문서가 주어진다. 문서의 길이는 최대 2500이다. 둘째 줄에 검색하고 싶은 단어가 주어진다. 이 길이는 최대 50이다. 문서와 단어는 알파벳 소문자와 공백으로 이루어져 있다.

</aside>

## 출력

<aside>
💡 첫째 줄에 중복되지 않게 최대 몇 번 등장하는지 출력한다.

</aside>

### 예제 입력 1

```jsx
ababababa
aba
```

### 예제 출력 1

```jsx
2
```

### 예제 입력 2

```jsx
a a a a a
a a
```

### 예제 출력 2

```jsx
2
```

### 예제 입력 3

```jsx
ababababa
ababa
```

### 예제 출력 3

```jsx
1
```

### 예제 입력 4

```jsx
aaaaaaa
aa
```

### 예제 출력 4

```jsx
3
```

# 풀이법 생각

<aside>
💡 단어를 찾다가 단어를 발견했을 경우, 찾은 위치에서 다시 찾는게 아니라 위치를 찾는 단어의 길이만큼 더한 다음에 검색을 시작한다.

</aside>

# 내 풀이

## 1차 풀이

### 코드

```java
package BOJ_1543_S5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        char[] doc_to_char = doc.toCharArray();
        char[] word_to_char = word.toCharArray();

        int doc_len = doc.length();
        int word_len = word.length();
        int word_count = 0;

        for(int i=0; i<= doc_len - word_len;  ){
            if(doc_to_char[i] == word_to_char[0]){
                int j;
                for(j=1; j<word_len; j++){
                    if(doc_to_char[i+j] != word_to_char[j]){
                        break;
                    }
                }

                if(j == word_len){
                    word_count++;
                    i+=word_len;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }

        System.out.println(word_count);
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
package BOJ_1543_S5;

import java.util.Scanner;

public class Answer {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();
        int startIndex = 0;
        int count = 0;
        while (true) {
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0)
                break;
            startIndex = findIndex + word.length();
            count++;
        }
        System.out.println(count);
    }
}
```

`indexOf` 라는 함수를 사용해서 매우 간단하게 풀었음