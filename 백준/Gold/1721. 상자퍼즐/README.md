# [Gold III] 상자퍼즐 - 1721 

[문제 링크](https://www.acmicpc.net/problem/1721) 

### 성능 요약

메모리: 19124 KB, 시간: 204 ms

### 분류

백트래킹, 브루트포스 알고리즘, 구현

### 제출 일자

2025년 6월 10일 14:47:33

### 문제 설명

<p>윗면과 네 개의 옆면, 총 다섯 개의 면에 정수가 적힌 정육면체 모양의 상자가 n<sup>2</sup>개가 있다. 이 상자들을 n행 n열로 배열하는 퍼즐 문제를 풀어보자. 단 다음의 조건을 만족해야 한다.</p>

<ol>
	<li>상자는 지면에 평행하게 회전시킬 수 있다. 즉, 윗면은 언제나 천장을 바라보고 있는 상태여야 한다.</li>
	<li>상자의 배열이 끝난 후, 서로 인접한 두 상자의 인접한 면에 적힌 수는 같아야 한다.</li>
	<li>다른 상자와 인접해 있지 않은 면에 적힌 수는 0이어야 한다.</li>
</ol>

<p>다음과 같은 예를 들어 보자.</p>

<p style="text-align: center;"><img alt="" src="" style="width: 200px; height: 244px;"></p>

<p>동그라미 안에 적힌 것은 상자의 윗면에 적힌 숫자이고, 그 둘레에 적힌 것이 상자의 네 옆면에 적힌 숫자이다. 9개의 상자를 위와 같이 배열하면, 조건에 맞게 퍼즐을 푼 것이다.</p>

<p>각 상자에 적힌 숫자들이 주어졌을 때 위와 같이 퍼즐을 푸는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 n이 주어진다. (2 ≤ n ≤ 5)  둘째 줄부터 한 줄에 한 개씩 상자의 정보가 주어진다. 맨 처음 수는 윗면에 적힌 정수이고, 나머지 네 개의 수는 옆면에 적힌 정수를 위에서 보았을 때의 시계방향으로 나열한 것이다.</p>

<p>윗면에 적힌 정수는 n<sup>2</sup>보다 작거나 같은 자연수이고 중복되지 않는다. 옆면에 적힌 정수는 9보다 작거나 같은 음이 아닌 정수이다. 항상 풀 수 있는 퍼즐만 입력으로 주어진다.</p>

### 출력 

 <p>먼저, 상자 윗면에 적힌 정수를 행렬로 만들어 출력한다. 이어서, 각각의 상자에 대해 주어진 상태에서 시계방향으로 몇 번의 회전을 거쳤는지 0 이상 3 이하의 정수로 나타낸 것을 행렬로 만들어 출력한다.</p>

