import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); //시행 횟수

		// 입력값의 범위는 -4000 0 4000 해서 8001개
		int[] num = new int[8001];

		int sum = 0; //총 합계
		int max = Integer.MIN_VALUE; //최댓값
		int min = Integer.MAX_VALUE; //최솟값
		int median = 10000; //중앙값 -> 입력값 범위를 넘는걸로 초기화
		int mode = 10000; //최빈값

		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			sum += value;
			num[value + 4000]++;

			if (max < value) {
				max = value;
			}
			if (min > value) {
				min = value;
			}
		}


		int count = 0; // 중앙값 빈도 카운트
		int modeMax = 0; // 최빈값의 최댓값

		// 이전의 동일한 최빈값이 1번만 등장했는가?
		boolean flag = false;

		for (int i = min + 4000; i <= max + 4000; i++) {

			if (num[i] > 0) {

				
				  //중앙값 누적횟수가 전체 전체 길이의 절반미만
				 
				if (count < (n + 1) / 2) {
					count += num[i]; // i값의 빈도수를 count 에 누적
					median = i - 4000;
				}

				//빈도수가 더 높은것의 등장
				if (modeMax < num[i]) {
					modeMax = num[i];
					mode = i - 4000;
					flag = true; // 첫 등장
				}
				// 최빈값 최댓값과 같고 한 번만 중복
				else if (modeMax == num[i] && flag == true) {
					mode = i - 4000;
					flag = false;
				}
			}
		}

		System.out.println((int) Math.round((double) sum / n)); // 산술평균
		System.out.println(median); // 중앙값
		System.out.println(mode); // 최빈값
		System.out.println(max - min); // 범위
	}

}