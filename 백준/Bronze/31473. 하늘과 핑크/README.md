# [Bronze I] 하늘과 핑크 - 31473 

[문제 링크](https://www.acmicpc.net/problem/31473) 

### 성능 요약

메모리: 16116 KB, 시간: 136 ms

### 분류

애드 혹, 수학

### 제출 일자

2025년 4월 17일 19:18:19

### 문제 설명

<p>시현이의 방구석에 핑크색 머리카락과 하늘색 머리카락이 각각 $N$개씩 떨어져 있었다!</p>

<p>시현이는 이것들이 단비 양의 머리카락이라고 확신했다.</p>

<p>시현이가 열심히 머리카락들의 길이를 잰 결과 $i$번째 핑크색 머리카락의 길이는 $A_i$였고, $i$번째 하늘색 머리카락의 길이는 $B_i$였다. $(1 \leq i \leq N)$</p>

<p>열심히 머리카락들의 길이를 재고 나니 시현이는 $\left | a\sum_{i=1}^N A_i - b\sum_{i=1}^N B_i \right|$를 최소화할 수 있는 $-1\,000\,000$ 이상 $1\,000\,000$ 이하의 $0$이 아닌 정수 $a$와 $b$가 무엇인지 궁금해졌다.</p>

<p>시현이의 궁금증에 대신 답해주자!</p>

### 입력 

 <p>첫째 줄에 머리카락 쌍의 개수 $N$이 주어진다. $(1 \leq N \leq 1\,000)$</p>

<p>둘째 줄에 $A_1, A_2, \cdots, A_N$, 셋째 줄에 $B_1, B_2, \cdots, B_N$이 공백으로 구분되어 주어진다. $(1 \leq A_i, B_i \leq 100)$</p>

<p>입력의 모든 수는 정수이다.</p>

### 출력 

 <p>첫째 줄에 $\left |a\sum_{i=1}^N A_i - b\sum_{i=1}^N B_i \right|$가 최소가 되는 $a$와 $b$를 공백으로 구분하여 출력한다.</p>

<p>그러한 $(a, b)$ 쌍이 여러 개라면, 그중 아무거나 출력한다.</p>

