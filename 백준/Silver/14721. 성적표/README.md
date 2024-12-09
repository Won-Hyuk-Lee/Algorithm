# [Silver V] 성적표 - 14721 

[문제 링크](https://www.acmicpc.net/problem/14721) 

### 성능 요약

메모리: 16076 KB, 시간: 144 ms

### 분류

브루트포스 알고리즘

### 제출 일자

2024년 12월 9일 20:34:32

### 문제 설명

<p>동하는 이번 학기에도 F 학점을 받아 학사경고를 받았다. 더 이상 학사경고를 받지 않기 위해 동하는 공부를 하기로 결심했다.</p>

<p>동하는 공부를 얼만큼 하면 얼만큼 성적이 나오는지 궁금했다. 그래서 동하는 N명의 학생들에 대해 공부시간과 그에 따른 시험점수를 조사했다.</p>

<p>동하는 i번째 학생은 x<sub>i</sub>시간의 공부를 했고, y<sub>i</sub>점의 점수를 받았다는 사실을 알았다.</p>

<p>이 데이터로부터 공부를 x시간 했으면 시험 성적은 f(x) = ax + b일 것이라고 추정하려 한다. 동하를 위해 a와 b를 구해주자.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14721/1.png" style="height:262px; width:397px"></p>

<p>공부시간에 따른 시험성적을 예측하는 함수 f(x)는, 데이터 (x<sub>i</sub>, y<sub>i</sub>)에 대해, f(x<sub>i</sub>)와 y<sub>i</sub>의 차가 작아야 할 것이다. (I = 1, 2, 3, …, N)</p>

<p>이 개념을 수학적으로 형식화한 것이 RSS(Residual Sum of Squares)이다. RSS가 작으면 예측모형이 데이터에 잘 맞는 것이라고 할 수 있다.</p>

<p style="text-align:center">\[\text{RSS} = \sum_{i=1}^{n}{(y_i - f(x_i))^2}\]</p>

<p>100이하의 모든 양의 정수 a와 b중, RSS를 최소화하는 a와 b를 구하여라. 오버플로우에 주의하여라.</p>

### 입력 

 <p>첫 번째 줄에는 데이터의 수 N이 주어진다. (2 ≤ N ≤ 100)</p>

<p>두 번째 줄부터 N+1 번째 줄까지, 각 줄에는 i번 학생의 공부시간 x<sub>i</sub>와 시험점수 y<sub>i</sub>가 순서대로 주어진다. (1 ≤ x<sub>i</sub>, y<sub>i</sub> ≤ 1000, x<sub>i</sub>와 y<sub>i</sub>는 정수)</p>

### 출력 

 <p>RSS가 최소인 a와 b를 한 줄에 공백으로 구분하여 출력하여라.</p>

<p>RSS가 최소인 쌍 (a, b)가 여러 개인 경우는 입력으로 주어지지 않는다.</p>

