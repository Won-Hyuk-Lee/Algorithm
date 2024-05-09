import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//첫 선택으로 최적의 해를 구한다.
		//시작 시간은 종료시간보다 무조건 작으므로, 종료시간 기준으로 정렬한다.
		//가장 먼저 종료되는 것을 첫 선택으로
		//이후에 빠르게 끝나는 활동을 계속 고른다
		//종료 시간이 같을 경우에는 시작 시간이 더 빠른것을 고르되
		//끝난 시간 기준(현재시간)이 시작시간보다 늦은 애들로
		//반복한다.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] time = new int[n][2]; 

		for (int i = 0; i < n; i++)
		{
			time[i][0] = sc.nextInt(); // 시작시간
			time[i][1] = sc.nextInt(); // 종료시간
		}

		// 끝나는 시간을 기준으로 정렬
		Arrays.sort(time, new Comparator<int[]>()
		{

			@Override
			public int compare(int[] t1, int[] t2)
			{

				// 종료시간이 같을 경우 시작시간이 빠른순
				if (t1[1] == t2[1])
				{
					return t1[0] - t2[0];
				}

				return t1[1] - t2[1];
			}

		});

		int count = 0;
		int beforeEndTime = 0;

		for (int i = 0; i < n; i++)
		{

			// 방금 종료된시간이 다음 회의의 시작 시간보다 작거나 같다면 갱신한다.
			if (beforeEndTime <= time[i][0]) {
				beforeEndTime = time[i][1];
				count++;
			}
		}

		System.out.println(count);
	}

}