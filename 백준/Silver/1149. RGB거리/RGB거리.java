import java.util.Scanner;

public class Main {
	
	final static int RED = 0;
	final static int GREEN = 1;
	final static int BLUE = 2;
	
	static int[][] cost;
	static int[][] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
        
		cost = new int[n][3]; // 비용 배열 초기화
		dp = new int[n][3]; // 동적 프로그래밍 배열 초기화
		
		// 각 집의 색상별 비용
		for(int i = 0; i < n; i++) {
			cost[i][RED] = sc.nextInt();
			cost[i][GREEN] = sc.nextInt();
			cost[i][BLUE] = sc.nextInt();
		}
		
		// 첫번째 집은 각 색상 비용의 첫번째 값으로 초기화
		dp[0][RED] = cost[0][RED];
		dp[0][GREEN] = cost[0][GREEN];
		dp[0][BLUE] = cost[0][BLUE];
		
		// 각 집을 칠하는 비용을 DP로 계산
		for (int i = 1; i < n; i++) {
			dp[i][RED] = Math.min(dp[i-1][GREEN], dp[i-1][BLUE]) + cost[i][RED];
			dp[i][GREEN] = Math.min(dp[i-1][RED], dp[i-1][BLUE]) + cost[i][GREEN];
			dp[i][BLUE] = Math.min(dp[i-1][RED], dp[i-1][GREEN]) + cost[i][BLUE];
		}
		System.out.print(Math.min(dp[n-1][RED], Math.min(dp[n-1][GREEN], dp[n-1][BLUE])));
	}
}
