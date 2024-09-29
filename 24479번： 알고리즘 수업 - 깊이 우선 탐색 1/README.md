# 24479번: 알고리즘 수업 - 깊이 우선 탐색 1 - <img src="https://static.solved.ac/tier_small/9.svg" style="height:20px" /> Silver II

<!-- performance -->

<!-- 문제 제출 후 깃허브에 푸시를 했을 때 제출한 코드의 성능이 입력될 공간입니다.-->

<!-- end -->

## 문제

[문제 링크](https://boj.kr/24479)


<p>오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다.&nbsp;아빠가 수업한&nbsp;내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.</p>

<p><em>N</em>개의 정점과&nbsp;<em>M</em>개의 간선으로 구성된 무방향&nbsp;그래프(undirected graph)가 주어진다. 정점 번호는 1번부터&nbsp;<em>N</em>번이고 모든 간선의 가중치는 1이다. 정점 <i>R</i>에서 시작하여 깊이&nbsp;우선 탐색으로&nbsp;노드를 방문할 경우 노드의 방문 순서를 출력하자.</p>

<p>깊이 우선 탐색 의사 코드는&nbsp;다음과 같다.&nbsp;인접 정점은&nbsp;<strong>오름차순</strong>으로 방문한다.</p>

<pre>dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
&nbsp;   visited[R] &lt;- YES;  # 시작 정점 R을 방문 했다고 표시한다.
&nbsp;   for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 <strong>오름차순</strong>으로 방문한다)
        if (visited[x] = NO) then dfs(V, E, x);
}</pre>



## 입력


<p>첫째 줄에 정점의 수&nbsp;<em>N</em>&nbsp;(5&nbsp;≤&nbsp;<em>N</em>&nbsp;≤ 100,000), 간선의 수&nbsp;<em>M</em>&nbsp;(1 ≤&nbsp;<em>M</em>&nbsp;≤ 200,000), 시작 정점&nbsp;<em>R</em>&nbsp;(1 ≤&nbsp;<em>R</em>&nbsp;≤&nbsp;<em>N</em>)이 주어진다.</p>

<p>다음&nbsp;<em>M</em>개 줄에 간선 정보&nbsp;<code><em>u</em>&nbsp;<em>v</em></code>가 주어지며 정점&nbsp;<em>u</em>와 정점&nbsp;<em>v</em>의 가중치 1인 양방향 간선을&nbsp;나타낸다. (1 ≤&nbsp;<em>u</em>&nbsp;&lt;&nbsp;<em>v</em>&nbsp;≤&nbsp;<em>N</em>,&nbsp;<em>u</em>&nbsp;≠&nbsp;<em>v</em>) 모든 간선의 (<em>u</em>,&nbsp;<em>v</em>) 쌍의 값은 서로 다르다.</p>



## 출력


<p>첫째 줄부터&nbsp;<em>N</em>개의&nbsp;줄에 정수를 한 개씩 출력한다.&nbsp;<em>i</em>번째 줄에는 정점&nbsp;<em>i</em>의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.</p>



## 소스코드

[소스코드 보기](Main.java)