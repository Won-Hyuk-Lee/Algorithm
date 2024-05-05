class Solution {
		public int solution(int n) {
			//에라토스테네스의 체를 이용한다.
			//n까지 boolean배열 생성
			//2부터 n까지의 배수를 전부 false
			//그이후 숫자인 3도 N까지의 배수를 전부 false
			//계속 진행시 소수만 true로 남게 된다.
			boolean[] isDecimal = new boolean[n+1]; // 0부터 n까지 배열생성(+1안할시 n-1까지임)
			for (int i = 2; i <= n; i++) //0과 1은 X이므로 2부터
			{
				isDecimal[i] = true; //2부터 소수로 정의하고 시작
			}
			for (int i = 2; i * i <= n; i++) //N까지의 배수
			{
				if (isDecimal[i] == true) // 소수를 발견할경우(2부터 시작함)
				{
					for (int j = i * i; j <= n; j += i) //2부터 N까지의 모든 배수를
					{
						isDecimal[j] = false; //소수가 아니므로 false로 처리
					}
				}
			}
			int count = 0;
			for (int i = 2; i <= n; i++) //0과 1은 소수가 아니므로 2부터
			{
				if (isDecimal[i] == true) //소수인 것만 카운팅 
				{
					count++;
				}
			}
            int answer = 0;
            answer = count;
			return answer; // 반환
		}
	}