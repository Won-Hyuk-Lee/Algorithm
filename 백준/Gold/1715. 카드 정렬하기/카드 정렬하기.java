import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 우선순위 큐를 사용하여 최소 힙 구현
		PriorityQueue<Long> pq = new PriorityQueue<>();

		// 입력된 카드 묶음의 크기를 우선순위 큐에 추가함
		for (int i = 0; i < n; i++) {
			pq.add(sc.nextLong());
		}

		long totalComparisons = 0;

		// 큐에 2개 이상 있을 때까지 반복
		while (pq.size() > 1) {
			// 가장 작은 두 카드 묶음을 꺼내 합친다
			long smallest = pq.poll();
			long secondSmallest = pq.poll();
			long newBundle = smallest + secondSmallest;

			// 합친 결과를 비교 횟수에 추가
			totalComparisons += newBundle;

			// 합친 묶음을 다시 큐에 추가한다
			pq.add(newBundle);
		}

		// 총 비교 횟수 출력
		System.out.println(totalComparisons);
	}
}
