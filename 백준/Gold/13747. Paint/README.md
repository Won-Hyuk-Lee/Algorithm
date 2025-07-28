# [Gold III] Paint - 13747 

[문제 링크](https://www.acmicpc.net/problem/13747) 

### 성능 요약

메모리: 96808 KB, 시간: 1148 ms

### 분류

이분 탐색, 자료 구조, 다이나믹 프로그래밍, 우선순위 큐, 트리를 사용한 집합과 맵, 집합과 맵

### 제출 일자

2025년 7월 28일 20:06:05

### 문제 설명

<p>You are painting a picket fence with n slats, numbered from 1 to n. There are k painters willing to paint a specific portion of the fence. However, they don’t like each other, and each painter will only paint their given portion of the fence if no other painter overlaps their portion.</p>

<p>You want to select a subset of painters that do not conflict with each other, in order to minimize the number of unpainted slats. For example, suppose there are 8 slats, and 3 painters. One painter wants to paint slats 1→3, one wants to paint 2→6, and one wants to paint 5→8. By choosing the first and last painters, you can paint most of the slats, leaving only a single slat (slat 4) unpainted, with no overlap between painters.</p>

### 입력 

 <p>Each input will consist of a single test case. Note that your program may be run multiple times on different inputs. The first line of input contains two integers n (1 ≤ n ≤ 10<sup>18</sup>) and k (1 ≤ k ≤ 200,000), where n is the number of slats and k is the number of painters. Each of the next k lines contains two integers a and b (1 ≤ a ≤ b ≤ n), indicating that this painter wants to paint all of the slats between a and b, inclusive.</p>

### 출력 

 <p>Output a single integer, which is the smallest number of slats that go unpainted with an optimal selection of painters.</p>

