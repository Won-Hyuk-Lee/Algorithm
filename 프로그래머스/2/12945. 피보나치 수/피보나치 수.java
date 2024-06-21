class Solution {
	public int solution(int n) {
		int answer = fibonacci(n);
		System.out.println(answer);
		return answer;
	}

	public int fibonacci(int n) {
		int[] cache = new int[n + 1];

		cache[0] = 0;
		cache[1] = 1;

		for (int i = 2; i <= n; i++) {
			// 값들을 1234567로 나눈 나머지로 저장한다.
			cache[i] = (cache[i - 1] + cache[i - 2]) % 1234567;
		}

		return cache[n] % 1234567;
	}
}
