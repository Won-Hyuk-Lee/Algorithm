# [Silver II] 욱제가 풀어야 하는 문제 - 18249 

[문제 링크](https://www.acmicpc.net/problem/18249) 

### 성능 요약

메모리: 35184 KB, 시간: 392 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 6월 27일 18:20:42

### 문제 설명

<p><a href="https://www.acmicpc.net/user/wo_okje">wo_okje</a>의 Codeforces 레이팅은 언제나 민트에 머물러 있다. 블루를 가기 위해 대회에 참가한 욱제는 A번 문제와 B번 문제를 합해 3분 만에 풀어내는 데 성공하고야 말았다! 신나게 C번 문제로 넘어간 욱제는 다음 문제를 마주치고 말았다. </p>

<p>당신에게 그래프가 주어진다. 이 그래프는 자연수 <em>N</em>(1 ≤ <em>N</em> ≤ 191,229)으로 표현되며, 다음과 같은 정점과 간선을 가진다.</p>

<ul>
	<li>그래프에는 <em>N</em>개의 빨간색 정점이 있으며, 각 정점은 1, 2, ..., <em>N</em>의 번호를 가진다.</li>
	<li>그래프에는 <em>N</em>개의 파란색 정점이 있으며, 각 정점은 1, 2, ..., <em>N</em>의 번호를 가진다.</li>
	<li>1 ≤ <em>i</em> ≤ <em>N</em>인 자연수 <em>i</em>에 대해 빨간색 <em>i</em>번 정점과 파란색 <em>i</em>번 정점을 연결하는 간선이 존재한다.</li>
	<li>2 ≤ <em>i</em> ≤ <em>N</em>인 자연수 <em>i</em>에 대해 빨간색 <em>i</em>-1번 정점과 파란색 <em>i</em>번 정점을 연결하는 간선이 존재한다.</li>
	<li>2 ≤ <em>i</em> ≤ <em>N</em>인 자연수 <em>i</em>에 대해 빨간색 <em>i</em>번 정점과 파란색 <em>i</em>-1번 정점을 연결하는 간선이 존재한다.</li>
</ul>

<p>서로 다른 두 간선이 끝점을 공유하지 않도록 정확히 <em>N</em>개의 간선을 고르는 방법의 수를 구하여라. 단, 수가 너무 커질 수 있으니 10<sup>9</sup>+7로 나눈 나머지를 출력하여라.</p>

<p>라는 내용의 문제를 1시간째 고민했지만 문제를 풀지 못해 블루를 가지 못할 것 같다는 생각이 든 <a href="https://www.acmicpc.net/user/wo_okje">wo_okje</a>는 당신에게 몰래 도움을 요청했다. <a href="https://www.acmicpc.net/user/wo_okje">wo_okje</a>를 위해 이 문제를 풀어주자!</p>

### 입력 

 <p>입력의 첫 번째 줄에 테스트 케이스의 수 <em>T</em>가 주어진다. (1 ≤ <em>T</em> ≤ 191,229)</p>

<p>이후 <em>T</em>개의 줄에 걸쳐 각각의 그래프를 나타내는 자연수 <em>N</em>이 주어진다. (1 ≤ <em>N</em> ≤ 191,229)</p>

### 출력 

 <p>문제에 대한 답을 한 줄에 하나씩 총 <em>T</em>개의 줄에 걸쳐 출력하여라.</p>

